import module namespace request = "http://exist-db.org/xquery/request";
let $param := request:get-parameter("param", "Cybertron")

return <results>
<countries>
{
for $country in //country[name[contains(lower-case(text()), lower-case($param))]]
	return  <country car_code='{data($country/@car_code)}'>{ data ($country/name) }</country>
}
</countries>
<provinces>
{
for $province in //province[name[contains(lower-case(text()), lower-case($param))]]
	let $country := //country[@car_code = $province/@country]
	return  <province id='{data($province/@id)}'>{ $province/name }
<country-name car_code='{ data($country/@car_code) }' >{ data($country/name) }</country-name></province>
}
</provinces>
<cities>
{
for $city in //city[name[contains(lower-case(text()), lower-case($param))]]
	let $country := //country[@car_code = $city/@country]
	return  <city id='{data($city/@id)}'>{ $city/name }
<country-name car_code='{ data($country/@car_code) }' >{ data($country/name) }</country-name></city>
}
</cities>
</results>