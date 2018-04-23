node 'default' {
 include essential
 include vim
 include cronagent
}

node 'TestcmdTJL' {
 include essential
 include man
 include vim
 include cronagent
 include mydevbox 
 
 package { 'pdfcrack' :
        ensure	=> installed,
        require	=> Exec['apt-update'],
 }
}

node 'myvm1', 'myvm2' {
 include essential
 include vim
 include cronagent
}

exec { 'apt-update' :
	command	=> '/usr/bin/apt-get update',
}

