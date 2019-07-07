<?php
	$db_link = mysqli_connect('localhost','root','','bar_webservice');

	if(!$db_link){
		echo "Verbindung wurder nicht hergestellt!";
	}
?> 	