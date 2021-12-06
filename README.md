# modeswitcher

In order to detect relevant security vulnerabilities, and in turn, to react to reported vulnerabilities appropriately, automation support is needed to reduce the manual effort required for these tasks.
Our model-driven framework can be used for developing and managing multi-modal architectures, modes, and modes switches. If a vulnerability is detected modes are switched automatically to overcome and reduce the risk, until software vendors provide patches and system administrators install them.

For demonstrating the feasibility and potential benefits of our approach described in Paper XXX, we performed a case study for Web server security. More specifically, the combination of a web server and a PHP interpreter, as this combination is used by many common content management systems (CMSs) such as WordPress, Joomla or Typo 3.
Typically, an instance of a CMS uses only a single (type of) web server. We investigate how mode switching can improve security and protect the system from reported vulnerabilities by applying our Mode DSL and the accompanying mode switching framework.

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
