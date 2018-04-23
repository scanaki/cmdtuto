include mydevbox 

package { 'pdfcrack' :
       ensure	=> installed,
       require	=> Exec['apt-update'],
}

