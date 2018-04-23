class mydevbox {

 package { 'groovy2' :
 	ensure	=> installed,
 	require	=> Exec['apt-update'],
 }
 
 package { 'groovy2-doc' :
 	ensure	=> installed,
 	require	=> Exec['apt-update'],
 }
 
 package { 'gcc' :
 	ensure => installed,
 	require => Exec['apt-update'],
 }

 package { 'javacc' :
 	ensure => installed,
 	require => Exec['apt-update'],
 }

 package { 'javacc-doc' :
 	ensure => installed,
 	require => Exec['apt-update'],
 }

 package { 'manpages-dev' :
        ensure => installed,
        require => Exec['apt-update'],
 }

 package { 'manpages-fr-dev' :
        ensure => installed,
        require => Exec['apt-update'],
 }

}
