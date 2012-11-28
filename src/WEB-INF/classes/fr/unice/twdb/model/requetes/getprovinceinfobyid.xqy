import module namespace request = "http://exist-db.org/xquery/request";
let $param := request:get-parameter("param", "Cybertron")
for $a in //province[@id = $param]
return
	if (exists($a))
		then <province  id="{ $a/@id } " capital=" { $a/@capital } " country="{ $a/@country }" country-name="{ //country[ @car_code = $a/@country ]/name }" >
{ $a/* }
</province>
	else ""