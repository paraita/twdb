<?xml version="1.0" encoding="ISO-8859-1" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">

	<xsl:output method="html" />

	<xsl:import href="templatehtml.xsl" />

	<xsl:template match="results">
		<xsl:choose>
			<xsl:when test="countries/country or cities/city or provinces/province">
				<h1>Résultats de la recherche :</h1>
				<xsl:apply-templates />
			</xsl:when>
			<xsl:otherwise>
				<h1>Votre recherche n'a retourné aucun résultat.</h1>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>


	<xsl:template match="countries">
		<xsl:if test="country">
			<h3>Les pays suivant ont été trouvés :</h3>
			<ul>
				<xsl:apply-templates select="country" />
			</ul>
		</xsl:if>
	</xsl:template>

	<xsl:template match="country">
		<li>
			<a href="./country/{@car_code}.html">
				<xsl:value-of select="current()" />
			</a>
		</li>
	</xsl:template>

	<xsl:template match="provinces">
		<xsl:if test="province">
			<h3>Les provinces suivantes ont été trouvées :</h3>
			<ul>
				<xsl:apply-templates select="province" />
			</ul>
		</xsl:if>
	</xsl:template>

	<xsl:template match="province">
		<li>
			<a href="./province/{@id}.html">
				<xsl:value-of select="name" />
			</a> - <a href="./country/{country-name/@car_code}.html"> <xsl:value-of select="country-name" /></a>
		</li>
	</xsl:template>
	
	<xsl:template match="cities">
		<xsl:if test="city">
			<h3>Les villes suivantes ont été trouvées :</h3>
			<ul>
				<xsl:apply-templates select="city" />
			</ul>
		</xsl:if>
	</xsl:template>

	<xsl:template match="city">
		<li>
			<a href="./city/{@id}.html">
				<xsl:value-of select="name" />
			</a> - <a href="./country/{country-name/@car_code}.html"> <xsl:value-of select="country-name" /></a>
		</li>
	</xsl:template>
	

</xsl:stylesheet>