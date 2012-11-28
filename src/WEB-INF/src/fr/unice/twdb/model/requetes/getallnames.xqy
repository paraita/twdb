<countries>
{
for $country in //country
return <country car_code='{data($country/@car_code)}'>{ data ($country/name) }</country>
}
</countries>