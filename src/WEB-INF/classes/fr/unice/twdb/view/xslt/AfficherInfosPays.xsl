<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="html"/>

	<xsl:import href="templatehtml.xsl"/>
	
	<xsl:template match="country">
        <article>
        	<header class="nomtitre"><xsl:value-of select="name" /></header>
        	<section id="entete_pays">
        		<div id="map_section"></div>
        		<section id="infos_gene">
        			<header>Infos générales:</header>
		        		<ul>
		        			<li>Continent : <xsl:value-of select="encompassed/@continent" /></li>
		        			<li>Capitale : <a href="/TWDB/city/{@capital}.html"><xsl:value-of select="//city[@id = /country/@capital]/name" /></a></li>
		        			<xsl:if test="languages">
		        			<li>Langues : <ul><xsl:apply-templates select="languages"/></ul></li>
		        			</xsl:if>
		        			<li>Population : <xsl:apply-templates select="population"/></li>
		        		</ul>
        		</section>
        	</section>
        	<section>
        		<header>Géographie:</header>
        		<ul>
        			<li>Superficie : <xsl:value-of select="@area"/> km<sup>2</sup></li>
        			<xsl:if test="province">
        				<li>Provinces : <ul><xsl:apply-templates select="province"/></ul></li>
        			</xsl:if>
        			<xsl:if test="border">
        			<li>Pays frontaliers : <xsl:apply-templates select="border"/></li>
        			</xsl:if>
        		</ul>
        	</section>
        	<section>
        		<header>Politique:</header>
        		<ul>
        			<li>Régime : <xsl:value-of select="government" /></li>
        			<!-- <li>Organisations : <xsl:value-of select="@memberships"/> </li> -->
        		</ul>
        	</section>
        	<xsl:if test="population_growth and infant_mortality">
        	<section>
        		<header>Population :</header>
        		<ul>
        		<xsl:if test="population_growth">
        			<li>Croissance : <xsl:value-of select="population_growth" /></li>
        			</xsl:if>
        			<xsl:if test="infant_mortality">
        			<li>Taux de mortalité infantile : <xsl:value-of select="infant_mortality" /></li>
        			</xsl:if>
        		</ul>
        	</section>
        	</xsl:if>
        	<xsl:if test="religions" >
        	<section>        	
        		<header>Religions:</header>
        		<table>
        		<xsl:apply-templates select="religions"/>
        		</table>
        		
        	</section>
        	</xsl:if>
        	
        	<script>
        	var position = new google.maps.LatLng(<xsl:value-of select="//city[@id = /country/@capital]/latitude" />,
        										  <xsl:value-of select="//city[@id = /country/@capital]/longitude" />);
			google.maps.event.addDomListener(window,'load',initialize(position, 'map_section'));
			
			
			<xsl:for-each select="//city">
				<xsl:if test="latitude">
				<xsl:if test="longitude">
					paysliens.push("/TWDB/city/<xsl:value-of select="@id"></xsl:value-of>.html");
					pos.push(new google.maps.LatLng(<xsl:value-of select="latitude" />,<xsl:value-of select="longitude" />));
					pays.push("<xsl:value-of select="name" />");
      			</xsl:if>
      			</xsl:if>
			</xsl:for-each>
			 drop(1);
		   	</script>
        	
        </article>
    </xsl:template>
    
    <xsl:template match="languages">
    	<li><xsl:value-of select="current()"/> - <xsl:value-of select="@percentage" />%</li>
    </xsl:template>
	
	<xsl:template match="province">
		<li><a href="/TWDB/province/{@id}.html"><xsl:value-of select="name"/></a></li>
	</xsl:template>
	
	<xsl:template match="border">
		<a href="{@country}.html"><xsl:value-of select="@country" /></a><xsl:text> </xsl:text>
	</xsl:template>
	
	<xsl:template match="religions">
		<tr>
		<td class="col_gauche"><xsl:value-of select="current()" /></td>
		<td><xsl:value-of select="@percentage" /> %</td>
		</tr>
	</xsl:template>
	
	<xsl:template match="population">
		<tr>
		<td><xsl:value-of select="@year" /></td>
		<td><xsl:value-of select="current()" /></td>
		</tr>
	</xsl:template>
	
	
	
</xsl:stylesheet>