
<?php
	
	require('DBConnection.php');

	$plz = $_POST["plz"];
	$nr = 1;
	if($plz == ""){
		$db_result = mysqli_query($db_link,"SELECT `bar_id`, `name`, `strasse`, `plz`, `ort` FROM bar")
		or die("Fehler: " . mysqli_error($db_link));
	}else{
		$db_result = mysqli_query($db_link,"SELECT `bar_id`, `name`, `strasse`, `plz`, `ort` FROM bar WHERE plz = $plz")
		or die("Fehler: " . mysqli_error($db_link));
	}

	echo ('<h1>' . "Bars in deiner Nähe: " . '</h1> <br>');
	while($row = mysqli_fetch_array($db_result)){

		echo ('<p>' . $nr .  '- ' . $row ['bar_id'] . ' ' . $row ['name'] . ' ' . $row ['strasse'] . ' ' . $row ['plz'] . ' ' . $row['ort'] . '</p>');
		$nr++;
	}

	include 'footer.php'
?>
