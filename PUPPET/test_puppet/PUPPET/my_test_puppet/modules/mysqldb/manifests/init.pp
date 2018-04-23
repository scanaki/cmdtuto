class mysqldb (
 root_password	=> 'default_password',
 port		=> '3306',
 ) {
 package { 'mysql-server' :
  ensure	=> present,
  require	=> Exec['apt-update'],
 }
 service { 'mysql' :
  ensure	=> running,
  enable	=> true,
 }
}

