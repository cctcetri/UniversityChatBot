<?php
$row = 1;
$z=0;
$data1[][] = "";
$data2[][] = "";
$n=0;#test 에 관한 함수
$q=0;#test2에 관한 함수
$test = $_GET["test"];
#$test ="학사지원팀";

if (($handle = fopen("test.csv", "r")) !== FALSE) {
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

$row=1;
$n=0;
if (($handle = fopen("test2.csv", "r")) !== FALSE) {
    while (($data = fgetcsv($handle, 1000, ",")) !== FALSE) {
        $num = count($data);
        $row++;
        for ($c=0; $c < $num; $c++) {
           $data2[$n][$c] =  $data[$c];
         #echo $data[$n][$c] . "<br />\n";

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

if($test =="이사장실"){
        echo  $data2[0][1];
}
