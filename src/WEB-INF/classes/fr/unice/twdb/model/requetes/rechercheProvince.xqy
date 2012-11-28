import module namespace request = "http://exist-db.org/xquery/request";
let $param := request:get-parameter("param", "Cybertron")
for $a in //country//province/name[text()= $param]
return
	if (exists($a))
		then $a/ancestor::province
	else ""