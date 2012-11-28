import module namespace request = "http://exist-db.org/xquery/request";
let $param := request:get-parameter("param", "Cybertron")
for $c in //country/name[text()= $param]
return
	if (exists($c))
		then $c/ancestor::country
		else ""