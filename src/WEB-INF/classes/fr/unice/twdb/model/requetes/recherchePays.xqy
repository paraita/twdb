import module namespace request = "http://exist-db.org/xquery/request";
let $param := request:get-parameter("param", "Cybertron")
(:return <resultat>{ $param }</resultat>:)
for $a in //country
return if(fn:contains($a/name, $param))
then <resultats> { $a } </resultats>
else()
 