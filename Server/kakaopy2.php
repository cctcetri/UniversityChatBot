<?php

$row = 1;
$n=0;#test 에 관한 함수




#echo $data1[0];
###############################################



if (($handle = fopen("final.csv", "r")) !== FALSE) {
    while (($data = fgetcsv($handle, 1000, ",")) !== FALSE) {
        $num = count($data);
        $row++;
        for ($c=0; $c < $num; $c++) {
           $data1[$n][$c] =  $data[$c];
     #      echo $data[$c] . "<br />\n";
        #       $z++     
    }

        $n++;
        }
 fclose($handle);
}

$a=$data1[0][0];


echo $a;
?>

