# Mode Switching Framework

In order to detect relevant security vulnerabilities, and in turn, to react to reported vulnerabilities appropriately, automation support is needed to reduce the manual effort required for these tasks. Our model-driven framework can be used for developing and managing multi-modal architectures, modes, and modes switches. If a vulnerability is detected modes are switched automatically to overcome and reduce the risk, until software vendors provide patches and system administrators install them.

For demonstrating the feasibility and potential benefits of our approach described in Paper XXX, we performed a case study for Web server security and analyzed the time span of two years, from Feb. 2019 to Feb. 2021. The combination of a web server and a PHP interpreter is used by many common content management systems (CMSs) such as WordPress, Joomla or Typo 3. Typically, an instance of a CMS uses only a single (type of) web server. We investigate how mode switching can improve security and protect the system from reported vulnerabilities by applying our Mode DSL and the accompanying mode switching framework.

For our case study, we created a system configuration with commonly used components: Linux distribution Debian 10 (Buster) and two different implementations of popular web servers in its most recent version: Apache2 (v2.4.38) and nginx (v1.14.2).

Additionally running on the web server, PHP (version 7.3) and FastCGI Process Manager are used to serve dynamic web content. Both web servers were selected because they provide similar functionality and work together with PHP. The web content was saved to the common /var/www directory, such that both web servers have access to it.

## Vulnerability Data Sources
* **Apache2 2.4.38 (17 Jan 2019)** `cpe:2.3:a:apache:http_server:2.4.38` [HTML](https://nvd.nist.gov/vuln/search/results?adv_search=true&query=cpe:2.3:a:apache:http_server:2.4.38), [JSON](https://services.nvd.nist.gov/rest/json/cpes/1.0?cpeMatchString=cpe:2.3:a:apache:http_server:2.4.38:*:*:*:*:*:*:*&addOns=cves), [HTML Vendor](https://httpd.apache.org/security/vulnerabilities_24.html)

* **Nginx (4 Dec 2018)** `cpe:2.3\:a:nginx:nginx:1.14.2`
[HTML](https://nvd.nist.gov/vuln/search/results?adv_search=true&query=cpe:2.3:a:nginx:nginx:1.14.2), [JSON](https://services.nvd.nist.gov/rest/json/cpes/1.0?cpeMatchString=cpe:2.3:a:nginx:nginx:1.14.2:*:*:*:*:*:*:*&addOns=cves), [HTML Vendor Changelog](https://nginx.org/en/CHANGES-1.16)

* **PHP 7.3.5 (2 May 2019)** `cpe:2.3\:a:php:php:7.3.5`
[HTML](https://nvd.nist.gov/vuln/search/results?adv_search=true&query=cpe:2.3:a:php:php:7.3.5), [JSON](https://services.nvd.nist.gov/rest/json/cpes/1.0?cpeMatchString=cpe:2.3:a:php:php:7.3.5:*:*:*:*:*:*:*&addOns=cves), [HTML Vendor Changelog](https://www.php.net/ChangeLog-7.php#PHP_7_3), [HTML Vendor Bugs](https://bugs.php.net)

## Patch Data Sources
Debian 10 (Buster): Linux Kernel 4.19, Release July 2019, Security support 2022, LTS 2024

* **Debian Patches:** [HTML](https://security-tracker.debian.org/tracker/), [JSON](https://security-tracker.debian.org/tracker/data/json)
* **Apache2:** [HTML](https://security-tracker.debian.org/tracker/source-package/apache2)
* **Nginx:** [HTML](https://security-tracker.debian.org/tracker/source-package/nginx)
* **PHP:** [HTML](https://security-tracker.debian.org/tracker/source-package/php7.3)

# Re-run the Web Server Case Study

## Requirements for Simulating Mode Switching
* **Installed Windows or Linux:** e.g, Windows 10 or [Debian Buster](https://www.debian.org/releases/buster/debian-installer)
* **Installed Java, to run the Framework:** `sudo apt install default-jdk`

## Extended Requirements for Executing Mode Switching
* **Installed and configured Apache2:** `sudo apt install apache2`
* **Installed and configured nginx:** `sudo apt install nginx`
* **Installed and configured PHP with FastCGI:** `sudo apt install php-fpm`

# Execute the Framework
To start the Mode Switching Framework please execute the command `java -jar WebServerCaseStudy-0.0.1-SNAPSHOP-jar-with-dependencies.jar`
The operating system (OS) will be automatically detected. If the OS is supported you can simulate and execute the action commands for the mode switch. Otherwise you can only simulate the mode switching.

```############################################################################
Welcome to the Mode Switching System!
############################################################################
Your operating system is linux
Distribution Debian detected
Regenerate system configuration from MDSL-Defintion not neccessary
Possible modes:[[apache, apacheWithPhp, nginxOnly, nginxWithPhp]]
############################################################################
What do you want to do? Choose an option:
----------------------------------------------------------------------------
[i]    Initialize
[m]    Show modes
[u]    Update CVEs, Patches and switch mode
[uv]   Update CVEs
[up]   Update Patches
[ams]  Automatic mode switch
[mms]  Manual mode switch
[s]    Show used software
[v]    Show all vulnerabilities
[vo]   Show open vulnerabilities
[vps]  Show vulnerabilities per software
[vs]   Show vulnerabilities statistics
[vsps] Show vulnerabilities statistics per software
[h]    Show mode history
[e]    Toggle mode (enabled/disabled)
[si]   Toggle simulation (on/off)
[ex]   Toggle execution (on/off)
[d]    Toggle debugging (on/off)

Start scenario:
[s1]   Start scenario vulnerability time series
[s2]   Start scenario all modes are disabled
[s3]   Start scenario all software is disabled
[s4]   Start scenario random mode order
[s5]   Start scenario mode switch duration

[q]    Quit
############################################################################
[? for menu]>```

```############################################################################
Welcome to the Mode Switching System!
############################################################################
Your operating system is windows 10
Your operating system is currently not supported!!
You can only simulate the mode switching
Regenerate system configuration from MDSL-Defintion not neccessary
Possible modes:[[apache, apacheWithPhp, nginxOnly, nginxWithPhp]]
############################################################################
What do you want to do? Choose an option:
----------------------------------------------------------------------------
[i]    Initialize
[m]    Show modes
[u]    Update CVEs, Patches and switch mode
[uv]   Update CVEs
[up]   Update Patches
[ams]  Automatic mode switch
[mms]  Manual mode switch
[s]    Show used software
[v]    Show all vulnerabilities
[vo]   Show open vulnerabilities
[vps]  Show vulnerabilities per software
[vs]   Show vulnerabilities statistics
[vsps] Show vulnerabilities statistics per software
[h]    Show mode history
[e]    Toggle mode (enabled/disabled)
[si]   Toggle simulation (on/off)
[ex]   Toggle execution (on/off)
[d]    Toggle debugging (on/off)

Start scenario:
[s1]   Start scenario vulnerability time series
[s2]   Start scenario all modes are disabled
[s3]   Start scenario all software is disabled
[s4]   Start scenario random mode order
[s5]   Start scenario mode switch duration

[q]    Quit
############################################################################
[? for menu]>
```

Then activate Debugging with Option `d` and start the scenario `s1`.

```[? for menu]> s1
############################################################################
Starting scenario vulnerability time series
############################################################################
2019-04-01 cpe:/:apache:http_server:2.4.38 [CVE-2019-0196] new vulnerability with score:5.3
2019-04-01 cpe:/:apache:http_server:2.4.38 [CVE-2019-0197] new vulnerability with score:4.2
2019-04-01 cpe:/:apache:http_server:2.4.38 [CVE-2019-0211] new vulnerability with score:7.8
2019-04-01 cpe:/:apache:http_server:2.4.38 [CVE-2019-0215] new vulnerability with score:7.5
2019-04-01 cpe:/:apache:http_server:2.4.38 [CVE-2019-0217] new vulnerability with score:7.5
2019-04-01 cpe:/:apache:http_server:2.4.38 [CVE-2019-0220] new vulnerability with score:5.3
2019-04-07 cpe:/:apache:http_server:2.4.38 [CVE-2019-0196] new patch
Automatic Mode Switch
----------------------------------------------------------------------------
############################################################################
Current mode >> null
----------------------------------------------------------------------------
Score        Avg      Prio  #CVE Enabled Name                    #Cnt/Starts
  0,0/  0,0  0,0/ 0,0    2  0/ 0    true nginxWithPhp               0/ 0
  0,0/  0,0  0,0/ 0,0    4  0/ 0    true nginxOnly                  0/ 0
 32,3/ 37,6  6,5/ 6,3    1  5/ 6    true apacheWithPhp              0/ 0
 32,3/ 37,6  6,5/ 6,3    3  5/ 6    true apache                     0/ 0
----------------------------------------------------------------------------
Suggested next mode >> nginxWithPhp
----------------------------------------------------------------------------
No current mode running
Complete start new mode nginxWithPhp
> /usr/bin/systemctl start nginx
> /usr/bin/systemctl start php7.3-fpm
File modes.log saved
Data serialized and saved to disk

...

2021-06-10 cpe:/:apache:http_server:2.4.38 [CVE-2021-26691] new patch
Automatic Mode Switch
----------------------------------------------------------------------------
############################################################################
Current mode >> nginxWithPhp
----------------------------------------------------------------------------
Score        Avg      Prio  #CVE Enabled Name                    #Cnt/Starts
  0,0/318,1  0,0/ 7,1    1  0/45    true apacheWithPhp              0/ 2
  0,0/207,2  0,0/ 7,1    2  0/29    true nginxWithPhp              14/ 6
  0,0/147,2  0,0/ 7,0    3  0/21    true apache                     0/ 4
  0,0/ 36,3  0,0/ 7,3    4  0/ 5    true nginxOnly                 18/ 4
----------------------------------------------------------------------------
Suggested next mode >> apacheWithPhp
----------------------------------------------------------------------------
Analyzing services of the new mode apacheWithPhp and the current mode nginxWithPhp
- currentMode stopServices:[[nginxService, phpFpmService]]
- newMode stopServices:[[apache2Service, apacheConfPhpFpmService, phpFpmService, apacheModSetenvifService, apacheModProxyFcgiService, apache2restart]]
Some services are equal and remain
- Following services remain:[[phpFpmService]]
- Following services are stopped:[[nginxService]]
> /usr/bin/systemctl stop nginx
- Following services are started:[[apache2Service, apacheModProxyFcgiService, apacheModSetenvifService, apacheConfPhpFpmService, apache2restart]]
> /usr/bin/systemctl start apache2
> /usr/sbin/a2enmod --quiet proxy_fcgi
> /usr/sbin/a2enmod --quiet setenvif
> /usr/sbin/a2enconf --quiet php7.3-fpm
> /usr/bin/systemctl restart apache2
File modes.log saved
Data serialized and saved to disk```
