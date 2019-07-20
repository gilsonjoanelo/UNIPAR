</div>
<?php 
echo "<script type=\"text/javascript\" src=\"$BASE_SCRIPTS/jquery-3.4.1.min.js\"></script>";
echo "<script type=\"text/javascript\" src=\"$BASE_SCRIPTS/jquery.validate.min.js\"></script>";
echo "<script type=\"text/javascript\" src=\"$BASE_SCRIPTS/site.js\"></script>";
if(isset($scriptList)) {
    if(is_array($scriptList)) {
        foreach ($scriptList as $value) {
            $script_url = $BASE_SCRIPTS . "/$value";
            echo "<script type=\"text/javascript\" src=\"$script_url\"></script>";
        }
    }
}
?>
</body>    
</html>