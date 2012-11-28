import module namespace request = "http://exist-db.org/xquery/request";
for $c in //country
order by fn:number($c/population) descending
return  <country>
        { $c/name }
        { $c/population }
</country>