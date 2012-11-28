import module namespace request = "http://exist-db.org/xquery/request";
let $param := request:get-parameter("param", "Cybertron")
(:return <resultat>{ $param }</resultat>:)
for $c in //country[@car_code = $param]
return
	if (exists($c))
		then $c
		else <vide />
