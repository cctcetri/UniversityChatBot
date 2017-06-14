
<?php
$row = 1;
if (($handle = fopen("test4.csv", "r")) !== FALSE) {
    while (($data = fgetcsv($handle, 1000, ",")) !== FALSE) {
        $num = count($data);
        echo "<p> $num fields in line $row: <br /></p>\n";
        $row++;
        for ($c=0; $c < $num; $c++) {
            echo $data[$c] . "<br />\n";
	 
       }
    }
    fclose($handle);
}

$address_book = array(
for ($i=0;$i<5;$i++){
 array($i+1)
}
 );




 $fp = fopen("pocket.csv","w") or die("Can't create file.");

 foreach($address_book as $line) {

 if ( fputcsv($fp,$line) === false ) die("Can't write.");

 }
  fclose($fp);




?>

