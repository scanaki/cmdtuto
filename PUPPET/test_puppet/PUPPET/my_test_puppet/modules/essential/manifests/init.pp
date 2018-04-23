class essential {
 package { 'wget' :
 	ensure	=> installed,
 	require	=> Exec['apt-update'],
 }
 
 package { 'curl' :
 	ensure	=> installed,
 	require	=> Exec['apt-update'],
 }
 
 package { 'less' :
 	ensure => installed,
 	require => Exec['apt-update'],
 }
 
}
