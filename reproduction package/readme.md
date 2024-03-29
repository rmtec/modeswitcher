# Reproduction package
The following links provide access to the vulnerabilities, patches, and vendor information of the used software packages Apache2, Nginx, and PHP.
We retrieved the vulnerabilities from the [Natural Vulnerability Database](https://nvd.nist.gov) (NVD) with the Common Platform Enumeration (CPE) Parameter, and the patches from [Debian Security Tracker](https://security-tracker.debian.org). 
We provide the raw results of our data sources in case the links are not working anymore: [nvd_nginx_nginx-1.14.2_cves.json](https://github.com/rmtec/modeswitcher/blob/main/reproduction%20package/nvd_nginx_nginx-1.14.2_cves.json), 
[nvd_apache-http_server-2.4.38_cves.json](https://github.com/rmtec/modeswitcher/blob/main/reproduction%20package/nvd_apache-http_server-2.4.38_cves.json), [nvd_php_php-7.3.5_cves.json](https://github.com/rmtec/modeswitcher/blob/main/reproduction%20package/nvd_php_php-7.3.5_cves.json), 
[debian-security-tracker-data.zip](https://github.com/rmtec/modeswitcher/blob/main/reproduction%20package/debian-security-tracker-data.zip).

## Vulnerabilities <a name="vulnerabilities"></a>
* **Apache2 2.4.38 (17 Jan 2019)** `cpe:2.3:a:apache:http_server:2.4.38` [HTML](https://nvd.nist.gov/vuln/search/results?adv_search=true&query=cpe:2.3:a:apache:http_server:2.4.38), [JSON](https://services.nvd.nist.gov/rest/json/cpes/1.0?cpeMatchString=cpe:2.3:a:apache:http_server:2.4.38:*:*:*:*:*:*:*&addOns=cves), [HTML Vendor](https://httpd.apache.org/security/vulnerabilities_24.html)

* **Nginx (4 Dec 2018)** `cpe:2.3\:a:nginx:nginx:1.14.2`
[HTML](https://nvd.nist.gov/vuln/search/results?adv_search=true&query=cpe:2.3:a:nginx:nginx:1.14.2), [JSON](https://services.nvd.nist.gov/rest/json/cpes/1.0?cpeMatchString=cpe:2.3:a:nginx:nginx:1.14.2:*:*:*:*:*:*:*&addOns=cves), [HTML Vendor Changelog](https://nginx.org/en/CHANGES-1.16)


* **PHP 7.3.5 (2 May 2019)** `cpe:2.3\:a:php:php:7.3.5`
[HTML](https://nvd.nist.gov/vuln/search/results?adv_search=true&query=cpe:2.3:a:php:php:7.3.5), [JSON](https://services.nvd.nist.gov/rest/json/cpes/1.0?cpeMatchString=cpe:2.3:a:php:php:7.3.5:*:*:*:*:*:*:*&addOns=cves), [HTML Vendor Changelog](https://www.php.net/ChangeLog-7.php#PHP_7_3), [HTML Vendor Bugs](https://bugs.php.net)

## Patches <a name="patches"></a>
Debian 10 (Buster): Linux Kernel 4.19, Release July 2019, Security support 2022, LTS 2024

* **Debian Patches:** [HTML](https://security-tracker.debian.org/tracker/), [JSON](https://security-tracker.debian.org/tracker/data/json)
* **Apache2:** [HTML](https://security-tracker.debian.org/tracker/source-package/apache2)
* **Nginx:** [HTML](https://security-tracker.debian.org/tracker/source-package/nginx)
* **PHP:** [HTML](https://security-tracker.debian.org/tracker/source-package/php7.3)
