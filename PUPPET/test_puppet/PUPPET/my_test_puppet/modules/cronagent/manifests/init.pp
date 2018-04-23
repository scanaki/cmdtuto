class cronagent {
 package { 'cron' :
  ensure => installed,
  require => Exec['apt-update'],
 }

 service { 'cron' :
  ensure => running,
  enable => true,
 }

 cron { 'agent-update' :
  command => '/opt/puppetlabs/puppet/bin/puppet agent --test',
  user => 'root',
  minute => '*/2',
 }

}
