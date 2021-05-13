# modeswitcher

In order to detect relevant security vulnerabilities, and in turn, to react to reported vulnerabilities appropriately, automation support is needed to reduce the manual effort required for these tasks.
Our model-driven framework can be used for developing and managing multi-modal architectures, modes, and modes switches. If a vulnerability is detected modes are switched automatically to overcome and reduce the risk, until software vendors provide patches and system administrators install them.

For demonstrating the feasibility and potential benefits of our approach described in Paper XXX, we performed a case study for Web server security. More specifically, the combination of a web server and a PHP interpreter, as this combination is used by many common content management systems (CMSs) such as WordPress, Joomla or Typo 3.
Typically, an instance of a CMS uses only a single (type of) web server. We investigate how mode switching can improve security and protect the system from reported vulnerabilities by applying our Mode DSL and the accompanying mode switching framework.

For our case study, we created a system configuration with commonly used components: Linux distribution Debian 10 (Buster) and two different implementations of popular web servers in its most recent version: Apache2 (v2.4.38) and nginx (v1.14.2).
Additionally running on the web server, PHP (version 7.3) and FastCGI Process Manager are used to serve dynamic web content. Both web servers were selected because they provide similar functionality and work together with PHP. The web content was saved to the common /var/www directory, such that both web servers have access to it.
