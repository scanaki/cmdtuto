class puppetlint {
	package { 'puppet-lint' :
		ensure		=> present,
		prodiver	=> 'gem',
	}
}

