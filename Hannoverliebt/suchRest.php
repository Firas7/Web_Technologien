<?php
    
    
    //Wurde das Suchfeld ausgefüllt?
    $sent=isset($_POST['sent'])? $_POST['sent'] : '';
    $suche= isset($_POST['suchstring'])? $_POST['suchstring'] : '';
    
    
     // Hier wird geprüft, ob die Suche leer ist und falls nicht wird die Eingabe mit der PLZ verglichen und die Liste zurueckgegeben
    if ($sent){
        foreach ($bars as  $bar):{
            
            if(empty($suche)){
                //echo $bar['name'] . $bar['strasse'];
                echo "<div class = 'menu-item'>";
                echo " <div class='menu-item-name'>". $bar['name'] ." ,   ".$bar['strasse']. " , ".$bar['plz']."  ".$bar['ort'] ." </div>";
                                echo " <div class='menu-item-price'> Telefon : 0511/". $bar['telefon']."</div>";

                echo "</div> <br/>";
                
            }elseif($bar['plz'] == $suche){
                echo "<div class='menu-item'>";
                echo "<div class='menu-item-name'>". $bar['name']." ,   ". $bar['strasse']. " , ". $bar['plz']."  ". $bar['ort']."</div>";
                echo " <div class='menu-item-price'> Telefon : 0511/". $bar['telefon']."</div>";
                echo "</div>";
                
            }
            
        } endforeach;
        
    }
    ?>

