<?php

$row = 1;
$n=0;#test 에 관한 함수


$state=$_GET['state'];

$address_book = array(

 array($state)
 );

$fp = fopen("st.csv","w") or die("Can't create file.");

 foreach($address_book as $line) {

 if ( fputcsv($fp,$line) === false ) die("Can't write.");

 }
  fclose($fp);

?>


