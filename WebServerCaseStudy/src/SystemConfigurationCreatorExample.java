import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SystemConfigurationCreatorExample {
	public static SystemConfiguration create() {
		List<Mode> modes = new ArrayList<Mode>();
		List<Software> software = new ArrayList<Software>();
		HashMap<String, Action> da = ModeSwitcher.getOS().getDefaultActions(); 
		
		Software swApache2 = new Software("apache2");
		Software swNginx = new Software("nginx");
		Software swPhp = new Software("php7.3");
		software.addAll(Arrays.asList(swApache2,swNginx,swPhp));
		//software.addAll(Arrays.asList(swApache2));

		Service apache2Service = new Service("Apache2", swApache2, da.get("startService").withParams("apache2"),
				da.get("stopService").withParams("apache2"));
		// Service apacheModPhpService = new Service("Apache2ModPhp", swPhp,
		// enableApacheMod.withParams("php7.3"), disableApacheMod.withParams("php7.3"));
		Service apacheModProxyFcgiService = new Service("Apache2ModProxyFcgi", da.get("enableApacheMod").withParams("proxy_fcgi"),
				da.get("disableApacheMod").withParams("proxy_fcgi"));
		Service apacheModSetenvifService = new Service("Apache2ModSetevif", da.get("enableApacheMod").withParams("setenvif"),
				da.get("disableApacheMod").withParams("setenvif"));
		Service apacheConfPhpFpmService = new Service("Apache2ConfPhpFpm", da.get("enableApacheConf").withParams("php7.3-fpm"),
				da.get("disableApacheConf").withParams("php7.3-fpm"));
		Service nginxService = new Service("Nginx", swNginx, da.get("startService").withParams("nginx"),
				da.get("stopService").withParams("nginx"));
		Service phpFpmService = new Service("PhpFpm", swPhp, da.get("startService").withParams("php7.3-fpm"),
				da.get("stopService").withParams("php7.3-fpm"));

		Mode apache2withPhpFpm = new Mode("apache2withPhpFpm","Apache2withPhpFpm", 1,
				Arrays.asList(apacheModProxyFcgiService, apacheModSetenvifService, apacheConfPhpFpmService,
						phpFpmService, apache2Service),
				Arrays.asList(apache2Service, phpFpmService, apacheConfPhpFpmService, apacheModSetenvifService,
						apacheModProxyFcgiService));
		Mode nginxWithPhpFpm = new Mode("nginxWithPhpFpm","NginxWithPhpFpm", 2, Arrays.asList(nginxService, phpFpmService),
				Arrays.asList(phpFpmService, nginxService));
		// Mode apache2WithModPhp = new Mode("Apache2 with Module PHP", 3,
		// Arrays.asList(apache2Service,apacheModPhpService),
		// Arrays.asList(apacheModPhpService,apache2Service));
		Mode apache2 = new Mode("apache2","Apache2", 4, apache2Service, apache2Service);
		Mode nginx = new Mode("nginx","Nginx", 5, nginxService, nginxService);
		// modes = Arrays.asList(apache2, apache2WithModPhp, apache2withPhpFpm, nginx,
		// nginxWithPhpFpm);
		modes = Arrays.asList(apache2, apache2withPhpFpm, nginx, nginxWithPhpFpm);
		// modes = Arrays.asList(apache2WithModPhp, apache2withPhpFpm, nginxWithPhpFpm);
		// modes = Arrays.asList(apache2, apache2WithModPhp, apache2withPhpFpm);
		// modes = Arrays.asList(nginx, nginxWithPhpFpm);
		// setDefaultMode(apache2);
		
		apache2.setAlternativeModes(Arrays.asList(nginx));
		apache2withPhpFpm.setAlternativeModes(Arrays.asList(nginxWithPhpFpm));
		nginx.setAlternativeModes(Arrays.asList(apache2));
		nginxWithPhpFpm.setAlternativeModes(Arrays.asList(apache2withPhpFpm));

		return new SystemConfiguration(modes, software);
	}
}
