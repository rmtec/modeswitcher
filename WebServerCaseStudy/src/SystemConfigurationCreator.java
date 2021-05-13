import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SystemConfigurationCreator{
		public static SystemConfiguration create() {
			List<Mode> modes  = new ArrayList<Mode>();
			HashMap<String, Software> software = new HashMap<String, Software>();
			String debianRelease;
			String releaseDate;
			debianRelease = "buster";
			releaseDate = "2019-07-06";
			
			Software apache_2_4_38 = new Software("apache","http_server","2.4.38", "apache2");
			software.put("cpe:/:apache:http_server:2.4.38", apache_2_4_38);
			Software nginx_1_14_2 = new Software("nginx","nginx","1.14.2", "nginx");
			software.put("cpe:/:nginx:nginx:1.14.2", nginx_1_14_2);
			Software php_7_3_5 = new Software("php","php","7.3.5", "php7.3");
			software.put("cpe:/:php:php:7.3.5", php_7_3_5);
			
			Action startLinuxService = new Action("", "servicectl start");
			Action stopLinuxService = new Action("", "servicectl stop");
			Action enableApacheMod = new Action("", "/sbin/a2enmod --quiet");
			Action disableApacheMod = new Action("", "/sbin/a2dismod -f --quiet");
			Action enableApacheConf = new Action("", "/sbin/a2enconf --quiet");
			Action disableApacheConf = new Action("", "/sbin/a2disconf --quiet");
			
			Service apache2Service = new Service("apache2Service",
				Arrays.asList(apache_2_4_38),
				Arrays.asList(startLinuxService.withParams("apache2")),
				Arrays.asList(stopLinuxService.withParams("apache2"))
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
				Arrays.asList(nginx_1_14_2),
				Arrays.asList(startLinuxService.withParams("nginx")),
				Arrays.asList(stopLinuxService.withParams("nginx"))
			);
			Service phpFpmService = new Service("phpFpmService",
				Arrays.asList(php_7_3_5),
				Arrays.asList(startLinuxService.withParams("php7.3-fpm")),
				Arrays.asList(stopLinuxService.withParams("php7.3-fpm"))
			);
			
			Mode apache = new Mode("Only static HTML pages", 3,
				Arrays.asList(apache2Service),
				Arrays.asList(apache2Service)
			);
			modes.add(apache);
			Mode apacheWithPhp = new Mode("Static HTML and dynamic PHP pages", 1,
				Arrays.asList(apacheModProxyFcgiService, apacheModSetenvifService, phpFpmService),
				Arrays.asList(phpFpmService, apacheModSetenvifService, apacheModProxyFcgiService)
			);
			modes.add(apacheWithPhp);
			Mode nginx = new Mode("Only static HTML pages", 4,
				Arrays.asList(nginxService),
				Arrays.asList(nginxService)
			);
			modes.add(nginx);
			Mode nginxWithPhp = new Mode("Static HTML and dynamic PHP pages", 2,
				Arrays.asList(apacheConfPhpFpmService),
				Arrays.asList(apacheConfPhpFpmService)
			);
			modes.add(nginxWithPhp);
			
			return new SystemConfiguration(modes, software, debianRelease, releaseDate);
		}
}
