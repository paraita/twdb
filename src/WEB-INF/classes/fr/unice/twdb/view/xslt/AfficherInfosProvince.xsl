<?xml version="1.0" encoding="ISO-8859-1" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:output method="html"/>

    <xsl:import href="templatehtml.xsl"/>

    <xsl:template match="province">
        <article>
        	<header class="nomtitre"><a href="/TWDB/country/{@country}.html"><xsl:value-of select="@country-name"/></a> -> <xsl:value-of select="name" /></header>
        	<div id="map_section_wide"></div>
        	<ul>
        		<li>Superficie: <xsl:value-of select="area" /> km<sup>2</sup></li>
        		<li>Population: <xsl:value-of select="population" /></li>
        	</ul>
        	<ul>
        		<li>Villes:
        			<ul>
        				<xsl:apply-templates select="city"/>
        			</ul>
        		</li>
        	</ul>
        </article>
        <script>
			var position = new google.maps.LatLng(<xsl:value-of select="city/latitude" />,<xsl:value-of select="city/longitude" />);
			google.maps.event.addDomListener(window,'load',initialize(position, 'map_section_wide'));
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
    </xsl:template>

    <xsl:template match="city">
		<li>
			<a href="/TWDB/city/{@id}.html"><xsl:value-of select="name"/></a>
		</li>
    </xsl:template>

</xsl:stylesheet>