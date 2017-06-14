<?php

$row = 1;
$n=0;#test 에 관한 함수

$t2=0;
$a=0;

$t1=$_GET['t1'];
#echo "t2sms",$t2
#echo $data1[0];
###############################################



$address_book = array(

 array($t1)
 );

$fp = fopen("ssss.csv","w") or die("Can't create file.");

 foreach($address_book as $line) {

 if ( fputcsv($fp,$line) === false ) die("Can't write.");

 }
  fclose($fp);
echo $t1;
?>
