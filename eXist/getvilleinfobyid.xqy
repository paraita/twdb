import module namespace request = "http://exist-db.org/xquery/request";
let $param := request:get-parameter("param", "Cybertron")
for $a in //city[@id = $param]
return
	if (exists($a))
		then <resultat>
				{$a}
			 	<province>
					{$a/ancestor::province/name}
			 	</province>
			 	<country>
					{$a/ancestor::country/name}
			 	</country>
			 </resultat>
	else ""