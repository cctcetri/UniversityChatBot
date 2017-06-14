<?php

$row = 1;
$n=0;#test 에 관한 함수


$send=$_GET['send'];
$msg=str_replace("@"," ",$send);
$address_book = array(

 array($msg)
 );

$fp = fopen("msg.csv","w") or die("Can't create file.");

 foreach($address_book as $line) {

 if ( fputcsv($fp,$line) === false ) die("Can't write.");

 }
  fclose($fp);

?>
