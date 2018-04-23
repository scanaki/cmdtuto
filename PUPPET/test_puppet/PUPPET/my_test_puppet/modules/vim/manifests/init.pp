class vim {
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
 
 file { 'vimrc' :
 	ensure => present,
	path => '/root/.vimrc',
	content => "syn on
colorscheme desert
",
	owner => 'root',
	group => 'root',
	mode => '0644',
 }
 
}
