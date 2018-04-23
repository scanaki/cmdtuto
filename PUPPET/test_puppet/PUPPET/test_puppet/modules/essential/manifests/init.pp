class essential {
 package { 'wget' :
 	ensure	=> installed,
 	require	=> Exec['apt-update'],
 }
 
 package { 'curl' :
 	ensure	=> installed,
 	require	=> Exec['apt-update'],
 }
 
 package { 'vim' :
 	ensure	=> installed,
 	require	=> Exec['apt-update'],
 }
 
 package { 'vim-doc' :
 	ensure	=> installed,
 	require	=> Exec['apt-update'],
 }
 
 package { 'vim-puppet' :
 	ensure	=> installed,
 	require	=> Exec['apt-update'],
 }
 
 package { 'vim-syntax-docker' :
 	ensure => installed,
 	require => Exec['apt-update'],
 }
 
 package { 'cron' :
 	ensure => installed,
 	require => Exec['apt-update'],
 }
 
 package { 'less' :
 	ensure => installed,
 	require => Exec['apt-update'],
 }
 
 package { 'man' :
 	ensure => installed,
 	require => Exec['apt-update'],
 }
 
 package { 'manpages' :
 	ensure => installed,
 	require => Exec['apt-update'],
 }
 
 package { 'manpages-fr' :
 	ensure => installed,
 	require => Exec['apt-update'],
 }
 
 package { 'manpages-fr-extra' :
 	ensure => installed,
 	require => Exec['apt-update'],
 }
 
}
