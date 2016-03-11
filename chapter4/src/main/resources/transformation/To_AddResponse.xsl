<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:param name="result" />

	<xsl:template match="/">
		<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
			xmlns:tem="http://tempuri.org/">
			<soapenv:Header />
			<soapenv:Body>
				<tem:AddResponse>
					<tem:AddResult>
						<xsl:value-of select="$result" />
					</tem:AddResult>
				</tem:AddResponse>
			</soapenv:Body>
		</soapenv:Envelope>
	</xsl:template>
</xsl:stylesheet>