<?php

$row = 1;
$z=0;
$data1[][] = "";
$data2[][] = "";
$data3[][] = "";
$n=0;#test 에 관한 함수
$q=0;#test2에 관한 함수
$test = $_GET["test"];
#$test ="목";
#echo $tsst;
if (($handle = fopen("bab3.csv", "r")) !== FALSE) {
    while (($data = fgetcsv($handle, 1000, ",")) !== FALSE) {
        $num = count($data);
        $row++;
        for ($c=0; $c < $num; $c++) {
           $data1[$n][$c] =  $data[$c];
        #   echo $data[$n][$c] . "<br />\n";
        #       $z++     
    }

        $n++;

        }


 fclose($handle);
}


#$test = $_GET['test'];

#$test = "";
#for($i=0; $i<=$z;$i++){
#       if($test==$data[$i][1]){
#       echo $data[$i][1];
#       }
#
#}


if($test =="월"){
       echo  $data1[1][0];
}

if($test =="화"){
       echo  $data1[1][1];
}

if($test =="수"){
       echo  $data1[1][2];
}

if($test =="목"){
       echo  $data1[1][3];
}
if($test =="금"){
       echo  $data1[1][4];
}

?>

