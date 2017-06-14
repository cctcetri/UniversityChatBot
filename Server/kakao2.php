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

if($test =="입학관리팀"){
        echo  $data2[1][1];
}

if($test =="비서실"){
        echo  $data2[2][1];
}

if($test =="대학원교학팀"){
        echo  $data2[3][1];
}

if($test =="교수지원팀"){
        echo  $data2[4][1];
}

if($test =="학술자료팀"){
        echo  $data2[5][1];
}

if($test =="학사지원팀"){
        echo  $data2[6][1];
}

if($test =="학술정보팀"){
        echo  $data2[7][1];
}

if($test =="교육행정지원팀"){
        echo  $data2[8][1];
}

if($test =="학술정보관"){
        echo  $data2[9][1];
}
if($test =="기획전략팀"){
        echo  $data2[10][1];
}

if($test =="정보화팀"){
        echo  $data2[11][1];
}

if($test =="평가감사팀"){
        echo  $data2[12][1];
}

if($test =="대외홍보팀"){
        echo  $data2[13][1];
}

if($test =="국제교류협력팀"){
        echo  $data2[14][1];
}

if($test =="디자인아트평생교육원"){
        echo  $data2[15][1];
}

if($test =="예비군교육훈련"){
        echo  $data2[16][1];
}

if($test =="장학복지팀"){
        echo  $data2[17][1];
}

if($test =="신학협력팀"){
        echo  $data2[18][1];
}
if($test =="경력개발지원팀"){
        echo  $data2[19][1];
}

if($test =="학생상담센터"){
        echo  $data2[20][1];
}

if($test =="총무인사팀"){
        echo  $data2[21][1];
}

if($test =="양성평등상담소"){
        echo  $data2[22][1];
}

if($test =="재무회계팀"){
        echo  $data2[23][1];
}

if($test =="건강관리실"){
        echo  $data2[24][1];
}

if($test =="우체국"){
        echo  $data2[25][1];
}

if($test =="입학기획팀"){
        echo  $data2[28][1];
}


if($test =="IPP사업단"){
        echo  $data2[27][1];
}

?>



