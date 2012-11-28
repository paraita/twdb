import module namespace request = "http://exist-db.org/xquery/request";
<ul>
{
let $param := request:get-parameter("param", "Cybertron")
for $city in //city/name[contains(lower-case(text()), lower-case($param))]
return <li>{ $city }</li>
}
</ul>