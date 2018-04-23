class lamp
{
  File {
    owner => 'apache',
    group => 'apache',
  }
  group {'apache':
    gid => '80',
  }
  ->
  user { 'apache':
    gid => 'apache',
    uid => '80',
  }
  exec { 'apt-update':
    command => 'apt-get update',
    path    => ['/usr/bin', '/usr/sbin']
  }

  package { 'apache2':
    ensure  => installed,
    require => Exec['apt-update'],
  }

  service { 'apache2':
    ensure => running,
  }

  # install mysql-server package
  package { 'mysql-server':
    require => Exec['apt-update'],        # require 'apt-update' before installing
    ensure => installed,
  }

  # ensure mysql service is running
  service { 'mysql':
    ensure => running,
  }

  # install php5 package
  package { 'php7.0':
    require => [Exec['apt-update'], Package['apache2']],        # require 'apt-update' before installing
    ensure => installed,
  }

  # ensure info.php file exists
  file { '/var/www':
    ensure  => directory,
    mode    => '0755',
    require => [Package['apache2'], User['apache']],
  }
  ->
  file { '/var/www/html':
    ensure => directory,
    mode  => '0755',
  }
  ->
  file { '/var/www/html/info.php':
    ensure  => present,
    content => template("${module_name}/info.php.erb"),
    require => Package['apache2'],        # require 'apache2' package before creating
  }
}

