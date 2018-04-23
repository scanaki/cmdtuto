class nginx {
	service { "nginx" :
		ensure	=> $::nginx::manage_service_ensure,
		name	=> $::nginx::service_name,
		enable	=> $::nginx::manage_service_enable,
	}
	file { "nginx.conf" :
		ensure	=> present,
		path	=> "/etc/nginx/nginx.conf",
		source	=> [ 
			"puppet:///modules/site/nginx.conf--${::fqdn}",
			"puppet:///modules/site/nginx.conf" ],
	}
}

