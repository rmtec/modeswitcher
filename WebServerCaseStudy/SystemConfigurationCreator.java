import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SystemConfigurationCreator{
		public static SystemConfiguration create() {
			List<Mode> modes  = new ArrayList<Mode>();
			List<Software> software = new ArrayList<Software>();
			String debianRelease;
			String releaseDate;
			debianRelease = "Debian";
			
			Software apache2 = new Software("apache2");
			software.add(apache2);
			Software nginx = new Software("nginx");
			software.add(nginx);
			Software php7 = new Software("php7.3");
			software.add(php7);
			
			Action startService = new Action("", "/usr/bin/systemctl start");
			Action stopService = new Action("", "/usr/bin/systemctl stop");
			Action restartService = new Action("", "/usr/bin/systemctl restart");
			Action reloadService = new Action("", "/usr/bin/systemctl reload");
			Action enableApacheMod = new Action("", "/usr/sbin/a2enmod --quiet");
			Action disableApacheMod = new Action("", "/usr/sbin/a2dismod -f --quiet");
			Action enableApacheConf = new Action("", "/usr/sbin/a2enconf --quiet");
			Action disableApacheConf = new Action("", "/usr/sbin/a2disconf --quiet");
			Action sedReplace = new Action("", "sed -i 's/$0\\s*=.*/$1/g' $2");
			Action phpConfigReplace = new Action("", "sed -i 's/$0\\s*=.*/$0=$1/g' ~/php.ini");
			Action enablePhpFileUploads = new Action("", "sed -i 's/file_uploads\\s*=.*/file_uploads=On/g' ~/php.ini");
			Action disablePhpFileUploads = new Action("", "sed -i 's/file_uploads\\s*=.*/file_uploads=Off/g' ~/php.ini");
			Action disablePhpOpenRemoteFiles = new Action("", "sed -i 's/allow_url_fopen\\s*=.*/allow_url_fopen=Off/g' ~/php.ini");
			Action enablePhpOpenRemoteFiles = new Action("", "sed -i 's/allow_url_fopen\\s*=.*/allow_url_fopen=On/g' ~/php.ini");
			Action setPhpUploadMaxFilesize = new Action("", "sed -i 's/upload_max_filesize\\s*=.*/upload_max_filesize=1M/g' ~/php.ini");
			Action setPhpErrorLoggingAll = new Action("", "sed -i 's/error_reporting\\s*=.*/error_reporting=E_ALL/g' ~/php.ini");
			Action apacheConfigReplace = new Action("", "sed -i 's#^$0.*#$1#' /etc/apache2/sites-enabled/000-default.conf");
			Action setWordpressApacheDocumentRoot = new Action("", "sed -i 's#^DocumentRoot.*#DocumentRoot /var/www/wordpress#' /etc/apache2/sites-enabled/000-default.conf");
			Action setDefaultApacheDocumentRoot = new Action("", "sed -i 's#^DocumentRoot.*#DocumentRoot /var/www#' /etc/apache2/sites-enabled/000-default.conf");
			Action nginxConfigReplace = new Action("", "sed -i 's#^$0.*#$1#' /etc/nginx/sites-enabled/default");
			Action setWordpressNginxDocumentRoot = new Action("", "sed -i 's#^root.*#root /var/www/wordpress;#' /etc/nginx/sites-enabled/default");
			Action setDefaultNginxDocumentRoot = new Action("", "sed -i 's#^root.*#root /var/www;#' /etc/nginx/sites-enabled/default");
			
			Service apache2Service = new Service("apache2Service",
				Arrays.asList(apache2),
				Arrays.asList(startService.withParams("apache2")),
				Arrays.asList(stopService.withParams("apache2"))
			);
			Service apacheModProxyFcgiService = new Service("apacheModProxyFcgiService",
				Arrays.asList(),
				Arrays.asList(enableApacheMod.withParams("proxy_fcgi")),
				Arrays.asList(enableApacheMod.withParams("proxy_fcgi"))
			);
			Service apacheModSetenvifService = new Service("apacheModSetenvifService",
				Arrays.asList(),
				Arrays.asList(enableApacheMod.withParams("setenvif")),
				Arrays.asList(disableApacheMod.withParams("setenvif"))
			);
			Service apacheConfPhpFpmService = new Service("apacheConfPhpFpmService",
				Arrays.asList(),
				Arrays.asList(enableApacheConf.withParams("php7.3-fpm")),
				Arrays.asList(disableApacheConf.withParams("php7.3-fpm"))
			);
			Service nginxService = new Service("nginxService",
				Arrays.asList(nginx),
				Arrays.asList(startService.withParams("nginx")),
				Arrays.asList(stopService.withParams("nginx"))
			);
			Service phpFpmService = new Service("phpFpmService",
				Arrays.asList(php7),
				Arrays.asList(startService.withParams("php7.3-fpm")),
				Arrays.asList(stopService.withParams("php7.3-fpm"))
			);
			Service apache2restart = new Service("apache2restart",
				Arrays.asList(),
				Arrays.asList(restartService.withParams("apache2")),
				Arrays.asList(reloadService.withParams("apache2"))
			);
			Service adaptApacheConfig = new Service("adaptApacheConfig",
				Arrays.asList(),
				Arrays.asList(setWordpressApacheDocumentRoot.withParams("")),
				Arrays.asList(setDefaultApacheDocumentRoot.withParams(""))
			);
			Service adaptNginxConfig = new Service("adaptNginxConfig",
				Arrays.asList(),
				Arrays.asList(setWordpressNginxDocumentRoot.withParams("")),
				Arrays.asList(setDefaultNginxDocumentRoot.withParams(""))
			);
			
			Mode apache = new Mode("apache","Only static HTML pages", 3,
				Arrays.asList(
				apache2Service),
				Arrays.asList(
				apache2Service)
			);
			modes.add(apache);
			Mode apacheWithPhp = new Mode("apacheWithPhp","Static HTML and dynamicX PHP pages", 1,
				Arrays.asList(apache2Service,
				apacheModProxyFcgiService, apacheModSetenvifService, phpFpmService, apacheConfPhpFpmService, apache2restart),
				Arrays.asList(apache2Service,
				apacheConfPhpFpmService, phpFpmService, apacheModSetenvifService, apacheModProxyFcgiService, apache2restart)
			);
			modes.add(apacheWithPhp);
			Mode nginxOnly = new Mode("nginxOnly","Only static HTML pages", 4,
				Arrays.asList(
				nginxService),
				Arrays.asList(
				nginxService)
			);
			modes.add(nginxOnly);
			Mode nginxWithPhp = new Mode("nginxWithPhp","Static HTML and dynamic PHP pages", 2,
				Arrays.asList(nginxService,
				phpFpmService),
				Arrays.asList(nginxService,
				phpFpmService)
			);
			modes.add(nginxWithPhp);
			
			apache.setAlternativeMode(nginxOnly);
			apacheWithPhp.setAlternativeMode(nginxWithPhp);
			nginxOnly.setAlternativeMode(apache);
			nginxWithPhp.setAlternativeMode(apacheWithPhp);
			
			return new SystemConfiguration(modes, software);
		}
}
