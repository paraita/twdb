<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	
	<xsl:output method="html"/>

	<xsl:import href="templatehtml.xsl" />

	<xsl:template match="resultat">
		<article>
			<header class="nomtitre">
			<a href="/TWDB/country/{city/@country}.html"><xsl:value-of select="country/name" /></a>
			<xsl:if test="province/name">
			-> <a href="/TWDB/province/{city/@province}.html"><xsl:value-of select="province/name" /></a>
			</xsl:if>
			-> <xsl:value-of select="city/name" /></header>
			<xsl:if test="city/latitude and city/longitude">
			<div id="map_section_wide"></div>			
		   </xsl:if>
			<section>
				<header>Infos:</header>
				<ul>
					<li>
						Population :<table>
						<thead><tr><td class="col_gauche">année</td><td>nombre d'habitants</td></tr></thead>
						<xsl:apply-templates select="city/population" />
						</table>
					</li>
				</ul>
			</section>
			<script>
			var position = new google.maps.LatLng(<xsl:value-of select="city/latitude" />,<xsl:value-of select="city/longitude" />);
			google.maps.event.addDomListener(window,'load',initialize(position, 'map_section_wide'));
      		<xsl:for-each select="//city">
				<xsl:if test="latitude">
				<xsl:if test="longitude">
					pos.push(new google.maps.LatLng(<xsl:value-of select="latitude" />,<xsl:value-of select="longitude" />));
					pays.push("<xsl:value-of select="name" />");
      			</xsl:if>
      			</xsl:if>
			</xsl:for-each>
			 drop(0);
		   </script>
		</article>
	</xsl:template>


	<xsl:template match="population">
		<tr>
			<td class="col_gauche">
			<xsl:value-of select="@year" />
			</td>
			<td>
				<xsl:value-of select="current()" />
			</td>
		</tr>
	</xsl:template>

</xsl:stylesheet>