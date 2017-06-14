<?php header("Content-Type: text/html; charset=UTF-8");


$row = 1;
$n=0;#test 에 관한 함수


$msg=$_POST['msg'];

$address_book = array(

 array($msg)
 );

$fp = fopen("final.csv","wb") or die("Can't create file.");

 foreach($address_book as $line) {

 if ( fputcsv($fp,$line) === false ) die("Can't write.");

 }
  fclose($fp);
echo $msg;
?>
