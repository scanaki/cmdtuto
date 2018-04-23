class man {
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
