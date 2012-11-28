import module namespace request = "http://exist-db.org/xquery/request";
for $continent in //continent
return <continent>
        {$continent/name}
         <countries>
        { for $country in //country
        where $country/encompassed/@continent = $continent/@id
        return $country/name
        }
</countries>
</continent>