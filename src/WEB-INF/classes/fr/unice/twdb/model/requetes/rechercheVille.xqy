import module namespace request = "http://exist-db.org/xquery/request";
let $param := request:get-parameter("param", "Cybertron")
for $a in //country//city/name[text() = $param]
return
	if (exists($a))
		then <resultat>
				{$a/ancestor::city}
			 	<province>
					{$a/ancestor::province/name}
			 	</province>
			 	<country>
					{$a/ancestor::country/name}
			 	</country>
			 </resultat>
	else ""