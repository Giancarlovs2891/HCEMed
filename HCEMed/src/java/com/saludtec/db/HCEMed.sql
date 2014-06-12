-- TABLAS HCEMed

CREATE TABLE  IF NOT EXISTS `HCEMed`.`Anamnesis` (
  `idAnamnesis` int(11) NOT NULL AUTO_INCREMENT,
  `idPaciente` int(11) DEFAULT NULL,
  `motivoConsulta` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `historiaEnfermedadActual` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `bajoMedicacion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `bajoMedicacionComentarios` longtext COLLATE utf8_spanish_ci,
  `alergia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hepatitis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `vih` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `anemia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `herpes` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `enfermedadRenal` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `artritis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ulcerasOrales` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `asma` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `diabetes` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hemorragias` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `problemasEndocrinos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fiebreReumatica` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cancer` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `problemasPsicologicos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `problemasTiroideos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `problemasCardiacos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `epilepsia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tuberculosis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `osteoporosis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hipertension` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `problemasPsiquiatricos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fechaDiagnosticoAlergia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tratamientoAlergia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `inicioTratamientoAlergia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hastaTratamientoAlergia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `medicacionAlergia` longtext COLLATE utf8_spanish_ci,
  `comentariosAlergia` longtext COLLATE utf8_spanish_ci,
  `fechaDiagnosticoHepatitis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tratamientoHepatitis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `inicioTratamientoHepatitis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hastaTratamientoHepatitis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `medicacionHepatitis` longtext COLLATE utf8_spanish_ci,
  `comentariosHepatitis` longtext COLLATE utf8_spanish_ci,
  `fechaDiagnosticoVih` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tratamientoVih` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `inicioTratamientoVih` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hastaTratamientoVih` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `medicacionVih` longtext COLLATE utf8_spanish_ci,
  `comentariosVih` longtext COLLATE utf8_spanish_ci,
  `fechaDiagnosticoAnemia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tratamientoAnemia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `inicioTratamientoAnemia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hastaTratamientoAnemia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `medicacionAnemia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `comentariosAnemia` longtext COLLATE utf8_spanish_ci,
  `fechaDiagnosticoHerpes` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tratamientoHerpes` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `inicioTratamientoHerpes` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hastaTratamientoHerpes` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `medicacionHerpes` longtext COLLATE utf8_spanish_ci,
  `comentariosHerpes` longtext COLLATE utf8_spanish_ci,
  `fechaDiagnosticoEnfermedadRenal` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tratamientoEnfermedadRenal` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `inicioTratamientoEnfermedadRenal` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hastaTratamientoEnfermedadRenal` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `medicacionEnfermedadRenal` longtext COLLATE utf8_spanish_ci,
  `comentariosEnfermedadRenal` longtext COLLATE utf8_spanish_ci,
  `fechaDiagnosticoArtritis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tratamientoArtritis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `inicioTratamientoArtritis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hastaTratamientoArtritis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `medicacionArtritis` longtext COLLATE utf8_spanish_ci,
  `comentariosArtritis` longtext COLLATE utf8_spanish_ci,
  `fechaDiagnosticoUlcerasOrales` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tratamientoUlcerasOrales` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `inicioTratamientoUlcerasOrales` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hastaTratamientoUlcerasOrales` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `medicacionUlcerasOrales` longtext COLLATE utf8_spanish_ci,
  `comentariosUlcerasOrales` longtext COLLATE utf8_spanish_ci,
  `fechaDiagnosticoAsma` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tratamientoAsma` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `inicioTratamientoAsma` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hastaTratamientoAsma` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `medicacionAsma` longtext COLLATE utf8_spanish_ci,
  `comentariosAsma` longtext COLLATE utf8_spanish_ci,
  `fechaDiagnosticoDiabetes` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tratamientoDiabetes` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `inicioTratamientoDiabetes` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hastaTratamientoDiabetes` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `medicacionDiabetes` longtext COLLATE utf8_spanish_ci,
  `comentariosDiabetes` longtext COLLATE utf8_spanish_ci,
  `fechaDiagnosticoHemorragias` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tratamientoHemorragias` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `inicioTratamientoHemorragias` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hastaTratamientoHemorragias` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `medicacionHemorragias` longtext COLLATE utf8_spanish_ci,
  `comentariosHemorragias` longtext COLLATE utf8_spanish_ci,
  `fechaDiagnosticoProblemasEndocrinos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tratamientoProblemasEndocrinos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `inicioTratamientoProblemasEndocrinos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hastaTratamientoProblemasEndocrinos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `medicacionProblemasEndocrinos` longtext COLLATE utf8_spanish_ci,
  `comentariosProblemasEndocrinos` longtext COLLATE utf8_spanish_ci,
  `fechaDiagnosticoFiebreReumatica` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tratamientoFiebreReumatica` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `inicioTratamientoFiebreReumatica` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hastaTratamientoFiebreReumatica` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `medicacionFiebreReumatica` longtext COLLATE utf8_spanish_ci,
  `comentariosFiebreReumatica` longtext COLLATE utf8_spanish_ci,
  `fechaDiagnosticoCancer` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tratamientoCancer` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `inicioTratamientoCancer` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hastaTratamientoCancer` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `medicacionCancer` longtext COLLATE utf8_spanish_ci,
  `comentariosCancer` longtext COLLATE utf8_spanish_ci,
  `fechaDiagnosticoProblemasPsicologicos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tratamientoProblemasPsicologicos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `inicioTratamientoProblemasPsicologicos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hastaTratamientoProblemasPsicologicos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `medicacionProblemasPsicologicos` longtext COLLATE utf8_spanish_ci,
  `comentariosProblemasPsicologicos` longtext COLLATE utf8_spanish_ci,
  `fechaDiagnosticoProblemasTiroideos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tratamientoProblemasTiroideos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `inicioTratamientoProblemasTiroideos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hastaTratamientoProblemasTiroideos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `medicacionProblemasTiroideos` longtext COLLATE utf8_spanish_ci,
  `comentariosProblemasTiroideos` longtext COLLATE utf8_spanish_ci,
  `fechaDiagnosticoProblemasCardiacos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tratamientoProblemasCardiacos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `inicioTratamientoProblemasCardiacos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hastaTratamientoProblemasCardiacos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `medicacionProblemasCardiacos` longtext COLLATE utf8_spanish_ci,
  `comentariosProblemasCardiacos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fechaDiagnosticoEpilepsia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tratamientoEpilepsia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `inicioTratamientoEpilepsia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hastaTratamientoEpilepsia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `medicacionEpilepsia` longtext COLLATE utf8_spanish_ci,
  `comentariosEpilepsia` longtext COLLATE utf8_spanish_ci,
  `fechaDiagnosticoTuberculosis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tratamientoTuberculosis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `inicioTratamientoTuberculosis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hastaTratamientoTuberculosis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `medicacionTuberculosis` longtext COLLATE utf8_spanish_ci,
  `comentariosTuberculosis` longtext COLLATE utf8_spanish_ci,
  `fechaDiagnosticoOsteoporosis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tratamientoOsteoporosis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `inicioTratamientoOsteoporosis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hastaTratamientoOsteoporosis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `medicacionOsteoporosis` longtext COLLATE utf8_spanish_ci,
  `comentariosOsteoporosis` longtext COLLATE utf8_spanish_ci,
  `fechaDiagnosticoHipertension` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tratamientoHipertension` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `inicioTratamientoHipertension` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hastaTratamientoHipertension` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `medicacionHipertension` longtext COLLATE utf8_spanish_ci,
  `comentariosHipertension` longtext COLLATE utf8_spanish_ci,
  `fechaDiagnosticoProblemasPsiquiatricos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tratamientoProblemasPsiquiatricos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `inicioTratamientoProblemasPsiquiatricos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hastaTratamientoProblemasPsiquiatricos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `medicacionProblemasPsiquiatricos` longtext COLLATE utf8_spanish_ci,
  `comentariosProblemasPsiquiatricos` longtext COLLATE utf8_spanish_ci,
  `fractura` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fechaFractura` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cadera` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tobillo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `femur` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `muneca` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `antebrazo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `vertebra` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `columna` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `otraFractura` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `otraFracturaComentarios` longtext COLLATE utf8_spanish_ci,
  `causaFractura` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `recuperacionPostFractura` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `incapacidadTotal` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `unidadIncapacidadTotal` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `otrosAntecedentesTraumatologicos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `menarquia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `menopausia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `histerectomia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `embarazos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `partos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `abortos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hijosVivos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ciclos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ur` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `infertilidad` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `lactancia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `totalLactancia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `edadDeLosHijos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tabaquismo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fumadorPasivo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fumaDesde` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `frecuenciaTabaquismo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `licor` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `frecuenciaLicor` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cerveza` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `vino` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ron` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `whiskey` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `aguardiente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `otrosLicores` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cafe` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `frecuenciaCafe` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `otroCafe` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `inicioCafe` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `lecheDerivados` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `frecuenciaLecheDerivados` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `otroLecheDerivado` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `inicioLecheDerivado` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `frutasFrescas` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `queClasesFrutasFrescas` longtext COLLATE utf8_spanish_ci,
  `porcionesFrutasFrescas` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `realizaEjercicio` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `frecuenciaEjercicio` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `pescados` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `pescadoRio` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `clasePescadoRio` longtext COLLATE utf8_spanish_ci,
  `vecesPescadoRio` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `desdePescadoRio` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `frecuenciaPescadoRio` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hastaPescadoRio` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `pescadoMar` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `blanco` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `clasePescadoMarBlanco` longtext COLLATE utf8_spanish_ci,
  `vecesPescadoMarBlanco` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `desdePescadoMarBlanco` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `frecuenciaPescadoMarBlanco` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hastaPescadoMarblanco` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `azules` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `clasePescadoMarAzules` longtext COLLATE utf8_spanish_ci,
  `vecesPescadoMarAzules` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `desdePescadoMarAzules` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `frecuenciaPescadoMarAzules` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hastaPescadoMarAzules` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `antecedentesQuirurgicos` longtext COLLATE utf8_spanish_ci,
  `otrosTratamientosAntecedentesQuirurgicos` longtext COLLATE utf8_spanish_ci,
  `comentariosAntecedentesQuirurgicos` longtext COLLATE utf8_spanish_ci,
  `diabetesPadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `diabetesMadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `diabetesHijo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `diabetesTioP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `diabetesTioM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `diabetesHnos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `diabetesAbueloP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `diabetesAbueloM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `diabetesNinguno` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `obesidadPadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `obesidadMadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `obesidadHijo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `obesidadTioP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `obesidadTioM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `obesidadHnos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `obesidadAbueloP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `obesidadAbueloM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `obesidadNinguno` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `colesterolPadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `colesterolMadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `colesterolHijo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `colesterolTioP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `colesterolTioM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `colesterolHnos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `colesterolAbueloP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `colesterolAbueloM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `colesterolNinguno` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `trigliceridosPadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `trigliceridosMadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `trigliceridosHijo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `trigliceridosTioP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `trigliceridosTioM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `trigliceridosHnos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `trigliceridosAbueloP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `trigliceridosAbueloM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `trigliceridosNinguno` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `infartosPadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `infartosMadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `infartosHijo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `infartosTioP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `infartosTioM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `infartosHnos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `infartosAbueloP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `infartosAbueloM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `infartosNinguno` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hipertensionPadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hipertensionMadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hipertensionHijo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hipertensionTioP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hipertensionTioM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hipertensionHnos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hipertensionAbueloP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hipertensionAbueloM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hipertensionNinguno` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cancerPadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cancerMadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cancerHijo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cancerTioP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cancerTioM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cancerHnos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cancerAbueloP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cancerAbueloM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cancerNinguno` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `osteoporosisPadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `osteoporosisMadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `osteoporosisHijo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `osteoporosisTioP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `osteoporosisTioM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `osteoporosisHnos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `osteoporosisAbueloP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `osteoporosisAbueloM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `osteoporosisNinguno` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `otrosPadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `otrosMadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `otrosHijo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `otrosTioP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `otrosTioM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `otrosHnos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `otrosAbueloP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `otrosAbueloM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `otrosNinguno` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `otrosComentariosTablaAntecedentesFamiliares` longtext COLLATE utf8_spanish_ci DEFAULT NULL,
  `fechaCreacionAn` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `horaCreacionAn` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAnamnesis`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE  IF NOT EXISTS `HCEMed`.`CirugiaPlastica` (
  `idCirugiaPlastica` int(11) NOT NULL AUTO_INCREMENT,
  `idPaciente` int(11) DEFAULT NULL,
  `esteticaCabezaCuello` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `alopecia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `caidaDeCabello` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `edadInicioDebilitamientoCapilar` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `edadInicioCaidaCapilar` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `estabilizada` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `antecedentesFamiliares` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tratamientosPrevios` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cortes` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `color` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `espesorCabello` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `estructura` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `poros` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `espesorCueroCabelludo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `flexibilidadCueroCabelludo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cicatrices` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `pullTest` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `componentesPsiquicos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `densidadZonaFrontal` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `densidadZonaOccipital` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `densidadZonaTemporal` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `densidadZonaParietal` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `perdidaZona` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tipoAlopeciaNoCicatricial` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `otroTipoDeAlopeciaNoCicatricial` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tipoAlopeciaCicatricial` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `otroTipoAlopeciaCicatricial` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `expectativasPaciente` longtext COLLATE utf8_spanish_ci,
  `propuestasTerapeuticas` longtext COLLATE utf8_spanish_ci,
  `gradoDeAlopeciaHombre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `gradoDeAlopeciaMujer` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `facial` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `antropometriaFrente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `comentariosAntropometriaFrente` longtext COLLATE utf8_spanish_ci,
  `antropometriaPerfil` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `comentariosAntropometriaPerfil` longtext COLLATE utf8_spanish_ci,
  `frente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `comentariosFrente` longtext COLLATE utf8_spanish_ci,
  `zonaPeriorbitaria` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `comentariosZonaPeriorbitaria` longtext COLLATE utf8_spanish_ci,
  `regionMalar` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `comentariosRegionMalar` longtext COLLATE utf8_spanish_ci,
  `regionMandibular` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `comentariosRegionMandibular` longtext COLLATE utf8_spanish_ci,
  `auricular` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `comentariosAuricular` longtext COLLATE utf8_spanish_ci,
  `nasal` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `comentariosNasal` longtext COLLATE utf8_spanish_ci,
  `periBucal` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `comentariosPeriBucal` longtext COLLATE utf8_spanish_ci,
  `mentoniana` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `comentariosMentoniana` longtext COLLATE utf8_spanish_ci,
  `cervical` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `comentariosCervical` longtext COLLATE utf8_spanish_ci,
  `esteticaCorporal` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `regionToracicaAnterior` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `antecedentesMamarios` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `comentariosAntecedentesMamarios` longtext COLLATE utf8_spanish_ci,
  `mamografias` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `comentariosMamografias` longtext COLLATE utf8_spanish_ci,
  `autoexamen` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `comentariosAutoexamen` longtext COLLATE utf8_spanish_ci,
  `volumenMamarioDerecho` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hipertrofiaVolumenMamarioDerecho` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `volumenMamarioIzquierdo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hipertrofiaVolumenMamarioIzquierdo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `formaMamariaDerecha` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `formaMamariaIzquierda` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ptosisMamaria` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `clasificacionPtosisRegnoult` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `gradoPtosisRegnault` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tipoPielDerecha` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tipoPielIzquierda` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `sensibilidadPezonDerecho` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `sensibilidadPezonIzquierdo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `diametroComplejoAreola` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `diagramaPosicionDerecho` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `baseMamariaDerecho` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `medidaToraxDerecho` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `diagramaPosicionIzquierdo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `baseMamariaIzquierdo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `medidaToraxIzquierdo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `diagnosticoMamario` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `otrosDiagnosticosMamarios` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `planTratamientoMamario` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ginecomastia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `clasificacionWiesman` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `antecedentesGinecomastia` longtext COLLATE utf8_spanish_ci,
  `tipoGinecomastia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `comentariosTipoGinecomastia` longtext COLLATE utf8_spanish_ci,
  `pectorales` longtext COLLATE utf8_spanish_ci,
  `otrosDiagnosticosGinecomastia` longtext COLLATE utf8_spanish_ci,
  `planTratamientoGinecomastia` longtext COLLATE utf8_spanish_ci,
  `abdomen` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `clasificacionMatarasso` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `comentariosAbdomen` longtext COLLATE utf8_spanish_ci,
  `diagnosticoAbdomen` longtext COLLATE utf8_spanish_ci,
  `planTratamientoAbdomen` longtext COLLATE utf8_spanish_ci,
  `espalda` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `comentariosEspalda` longtext COLLATE utf8_spanish_ci,
  `diagnosticoEspalda` longtext COLLATE utf8_spanish_ci,
  `planTratamientoEspalda` longtext COLLATE utf8_spanish_ci,
  `gluteos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `volumenGluteos` longtext COLLATE utf8_spanish_ci,
  `posicionGluteos` longtext COLLATE utf8_spanish_ci,
  `formaGluteos` longtext COLLATE utf8_spanish_ci,
  `caracteristicasPielGluteos` longtext COLLATE utf8_spanish_ci,
  `asimetria` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `secuelasTrauma` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `comentariosGluteos` longtext COLLATE utf8_spanish_ci,
  `extremidadesSuperiores` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `depositoGrasaMinimoModeradoMinimaLaxitud` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `depositoGrasaGeneralizadaModeradaLaxitud` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `obesidadGeneralizadaSeveraLaxitud` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `minimaGrasaSubcutaneaExtensaLaxitud` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `comentariosExtremidadesSuperiores` longtext COLLATE utf8_spanish_ci,
  `extremidadesInferiores` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `comentariosExtremidadesInferiores` longtext COLLATE utf8_spanish_ci,
  `diagnosticoExtremidadesInferiores` longtext COLLATE utf8_spanish_ci,
  `planTratamientoExtremidadesInferiores` longtext COLLATE utf8_spanish_ci,
  `reconstructivaCabezaCuello` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `comentariosReconstructivaCabezaCuello` longtext COLLATE utf8_spanish_ci,
  `diagnosticoReconstructivaCabezaCuello` longtext COLLATE utf8_spanish_ci,
  `planTratamientoReconstructivaCabezaCuello` longtext COLLATE utf8_spanish_ci,
  `reconstructivaCorporal` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `comentariosReconstructivaCorporal` longtext COLLATE utf8_spanish_ci,
  `diagnosticoReconstructivaCorporal` longtext COLLATE utf8_spanish_ci,
  `planTratamientoReconstructivaCorporal` longtext COLLATE utf8_spanish_ci,
  `fechaCreacionCp` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `horaCreacionCp` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `comentarioOtroColor` longtext COLLATE utf8_spanish_ci,
  `otraEstructura` longtext COLLATE utf8_spanish_ci,
  `otroComponentePsiquico` longtext COLLATE utf8_spanish_ci,
  `otraPerdidaZona` longtext COLLATE utf8_spanish_ci,
  `otroFormaMamariaDerecha` longtext COLLATE utf8_spanish_ci,
  `otroFormaMamariaIzquierda` longtext COLLATE utf8_spanish_ci,
  `otroTipoDePielDerecha` longtext COLLATE utf8_spanish_ci,
  `otroTipoDePielIzquierda` longtext COLLATE utf8_spanish_ci,
  `otraSensibilidadDerechaPezon` longtext COLLATE utf8_spanish_ci,
  `otraSensibilidadIzquierdaPezon` longtext COLLATE utf8_spanish_ci,
  `diametroComplejoAreolaDerecho` longtext COLLATE utf8_spanish_ci,
  `diametroComplejoAreolaIzquierdo` longtext COLLATE utf8_spanish_ci,
  `pronosticoMamario` longtext COLLATE utf8_spanish_ci,
  `pronosticoAbdomen` longtext COLLATE utf8_spanish_ci,
  `valoracionGenitourinaria` longtext COLLATE utf8_spanish_ci,
  `comentariosValoracionGenitourinaria` longtext COLLATE utf8_spanish_ci,
  `pronosticoEspalda` longtext COLLATE utf8_spanish_ci,
  `diagnosticoExtremidadesSuperiores` longtext COLLATE utf8_spanish_ci,
  `pronosticoExtremidadesSuperiores` longtext COLLATE utf8_spanish_ci,
  `planTratamientoExtremidadesSuperiores` longtext COLLATE utf8_spanish_ci,
  `pronosticoExtremidadesInferiores` longtext COLLATE utf8_spanish_ci,
  `pronosticoReconstructivaCabezaCuello` longtext COLLATE utf8_spanish_ci,
  `pronosticoReconstructivaCorporal` longtext COLLATE utf8_spanish_ci,
  `otroTipoGinecomastia` longtext COLLATE utf8_spanish_ci,
  `pronosticoGinecomastia` longtext COLLATE utf8_spanish_ci,
  PRIMARY KEY (`idCirugiaPlastica`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE  IF NOT EXISTS `HCEMed`.`descripcionPlanDeTratamiento` (
  `idDescripcionPlanTratamiento` int(11) NOT NULL AUTO_INCREMENT,
  `idPlanTratamiento` int(11) NOT NULL,
  `textoDescripcionPlanTratamiento` longtext COLLATE utf8_spanish_ci,
  `valorDescripcionPlanTratamiento` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDescripcionPlanTratamiento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE  IF NOT EXISTS `HCEMed`.`Diagnosticos` (
  `idDiagnostico` int(11) NOT NULL AUTO_INCREMENT,
  `idPaciente` int(11) DEFAULT NULL,
  `nombreModulo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombreDiagnostico` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `diagnostico` longtext COLLATE utf8_spanish_ci,
  `fecha` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hora` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDiagnostico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE  IF NOT EXISTS `HCEMed`.`Evolucion` (
  `idEvolucion` int(11) NOT NULL AUTO_INCREMENT,
  `idPaciente` int(11) DEFAULT NULL,
  `nombreModulo` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hora` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `evolucion` longtext COLLATE utf8_spanish_ci,
  `idUsuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEvolucion`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE  IF NOT EXISTS `HCEMed`.`EvolucionComentarios` (
  `idEvolucionComentario` int(11) NOT NULL AUTO_INCREMENT,
  `idPaciente` int(11) DEFAULT NULL,
  `firma` longtext COLLATE utf8_spanish_ci,
  `comentario` longtext COLLATE utf8_spanish_ci,
  `fecha` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hora` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEvolucionComentario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE  IF NOT EXISTS `HCEMed`.`ExamenFisico` (
  `idExamenFisico` int(11) NOT NULL AUTO_INCREMENT,
  `idPaciente` int(11) DEFAULT NULL,
  `tensionArterial` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `peso` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cintura` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `pulso` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `talla` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cadera` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `frecuenciaRespiratoria` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `bmi` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `indiceCintCad` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `piel` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `pielComentarioEf` longtext COLLATE utf8_spanish_ci,
  `ojos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ojosComentarioEf` longtext COLLATE utf8_spanish_ci,
  `oidosNarizGarganta` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `oidosNarizGargantaComentarioEf` longtext COLLATE utf8_spanish_ci,
  `cuello` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cuelloComentarioEf` longtext COLLATE utf8_spanish_ci,
  `torax` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `toraxComentarioEf` longtext COLLATE utf8_spanish_ci,
  `cardiovascular` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cardiovascularComentarioEf` longtext COLLATE utf8_spanish_ci,
  `respiratorios` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `respiratoriosComentarioEf` longtext COLLATE utf8_spanish_ci,
  `abdomen` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `abdomenComentarioEf` longtext COLLATE utf8_spanish_ci,
  `genitourinario` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `genitourinarioComentarioEf` longtext COLLATE utf8_spanish_ci,
  `extremidades` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `extremidadesComentarioEf` longtext COLLATE utf8_spanish_ci,
  `sistemaNerviosoCentral` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `sistemaNerviosoCentralComentarioEf` longtext COLLATE utf8_spanish_ci,
  `adenopatias` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `adenopatiasComentarioEf` longtext COLLATE utf8_spanish_ci,
  `otros` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `otrosComentarioEf` longtext COLLATE utf8_spanish_ci,
  `comentariosEf` longtext COLLATE utf8_spanish_ci,
  `condicionEf` longtext COLLATE utf8_spanish_ci,
  `fechaCreacionEf` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `horaCreacionEf` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idExamenFisico`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE  IF NOT EXISTS `HCEMed`.`Galeria` (
  `idFoto` int(11) NOT NULL AUTO_INCREMENT,
  `idPaciente` int(11) DEFAULT NULL,
  `foto` longtext COLLATE utf8_spanish_ci,
  `fecha` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hora` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idFoto`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE  IF NOT EXISTS `HCEMed`.`Pacientes` (
  `idPaciente` int(11) NOT NULL AUTO_INCREMENT,
  `alertaMedica` longtext COLLATE utf8_spanish_ci,
  `nombrePaciente` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `foto` longtext COLLATE utf8_spanish_ci,
  `apellidoPaciente` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fechaNacimientoPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tipoIdentificacionPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `identificacionPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `estadoPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `estadoCivilPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `sexoPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `razaPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ocupacionPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefonoPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `celularPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `emailPaciente` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `paisPaciente` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `departamentoPaciente` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ciudadPaciente` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nacionalidadPaciente` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `direccionPaciente` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `zonaResidencialPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `codigoPostalPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `estratoPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `companiaSeguroPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tipoVinculacionPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombreRepresentante` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellidoRepresentante` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tipoIdentificacionRepresentante` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `identificacionRepresentante` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefonoRepresentante` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `parentescoRepresentante` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombreEmergencia` varchar(150) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefonoEmergencia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `parentescoEmergencia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombreReferido` varchar(150) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fechaCreacion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `horaCreacion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPaciente`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE  IF NOT EXISTS `HCEMed`.`Pagos` (
  `idPago` int(11) NOT NULL AUTO_INCREMENT,
  `valorPago` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fechaPago` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idPlanTratamiento` int(11) NOT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE  IF NOT EXISTS `HCEMed`.`PlanesDeTratamiento` (
  `idPlanDeTratamiento` int(11) NOT NULL AUTO_INCREMENT,
  `idPaciente` int(11) NOT NULL,
  `fechaPlanTratamiento` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `impuestoPlanTratamiento` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `valorPlanTratamiento` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `pagadoPlanTratamiento` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPlanDeTratamiento`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE  IF NOT EXISTS `HCEMed`.`Tratamientos` (
  `idTratamiento` int(11) NOT NULL AUTO_INCREMENT,
  `desTratamiento` longtext COLLATE utf8_spanish_ci,
  `fechaTratamiento` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `horaTratamiento` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idPaciente` int(11) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTratamiento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE  IF NOT EXISTS `HCEMed`.`Usuarios` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombreUsuario` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellidoUsuario` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `usuarioLogin` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `contrasenaLogin` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `usuarioLogin_UNIQUE` (`usuarioLogin`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;


-- RELACIONES HCEMed

ALTER TABLE `HCEMed`.`Anamnesis` 
ADD INDEX `fk_idPacienteAn_idx` (`idPaciente` ASC);
ALTER TABLE `HCEMed`.`Anamnesis` 
ADD CONSTRAINT `fk_idPacienteAn`
  FOREIGN KEY (`idPaciente`)
  REFERENCES `HCEMed`.`Pacientes` (`idPaciente`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

ALTER TABLE `HCEMed`.`CirugiaPlastica` 
ADD INDEX `fk_idPacienteCp_idx` (`idPaciente` ASC);
ALTER TABLE `HCEMed`.`CirugiaPlastica` 
ADD CONSTRAINT `fk_idPacienteCp`
  FOREIGN KEY (`idPaciente`)
  REFERENCES `HCEMed`.`Pacientes` (`idPaciente`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

ALTER TABLE `HCEMed`.`descripcionPlanDeTratamiento` 
ADD INDEX `fk_idPlanTratDesc_idx` (`idPlanTratamiento` ASC);
ALTER TABLE `HCEMed`.`descripcionPlanDeTratamiento` 
ADD CONSTRAINT `fk_idPlanTratDesc`
  FOREIGN KEY (`idPlanTratamiento`)
  REFERENCES `HCEMed`.`PlanesDeTratamiento` (`idPlanDeTratamiento`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

ALTER TABLE `HCEMed`.`Diagnosticos` 
ADD INDEX `fk_idPacienteDiag_idx` (`idPaciente` ASC);
ALTER TABLE `HCEMed`.`Diagnosticos` 
ADD CONSTRAINT `fk_idPacienteDiag`
  FOREIGN KEY (`idPaciente`)
  REFERENCES `HCEMed`.`Pacientes` (`idPaciente`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

ALTER TABLE `HCEMed`.`Evolucion` 
ADD INDEX `fk_idPacienteEvo_idx` (`idPaciente` ASC);
ALTER TABLE `HCEMed`.`Evolucion` 
ADD CONSTRAINT `fk_idPacienteEvo`
  FOREIGN KEY (`idPaciente`)
  REFERENCES `HCEMed`.`Pacientes` (`idPaciente`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

ALTER TABLE `HCEMed`.`EvolucionComentarios` 
ADD INDEX `fk_idPacienteEvoComm_idx` (`idPaciente` ASC);
ALTER TABLE `HCEMed`.`EvolucionComentarios` 
ADD CONSTRAINT `fk_idPacienteEvoComm`
  FOREIGN KEY (`idPaciente`)
  REFERENCES `HCEMed`.`Pacientes` (`idPaciente`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

ALTER TABLE `HCEMed`.`ExamenFisico` 
ADD INDEX `fk_idPacienteEf_idx` (`idPaciente` ASC);
ALTER TABLE `HCEMed`.`ExamenFisico` 
ADD CONSTRAINT `fk_idPacienteEf`
  FOREIGN KEY (`idPaciente`)
  REFERENCES `HCEMed`.`Pacientes` (`idPaciente`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

ALTER TABLE `HCEMed`.`Galeria` 
ADD INDEX `fk_idPacienteGal_idx` (`idPaciente` ASC);
ALTER TABLE `HCEMed`.`Galeria` 
ADD CONSTRAINT `fk_idPacienteGal`
  FOREIGN KEY (`idPaciente`)
  REFERENCES `HCEMed`.`Pacientes` (`idPaciente`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

ALTER TABLE `HCEMed`.`Pacientes` 
ADD INDEX `fk_idUsuarioPac_idx` (`idUsuario` ASC);
ALTER TABLE `HCEMed`.`Pacientes` 
ADD CONSTRAINT `fk_idUsuarioPac`
  FOREIGN KEY (`idUsuario`)
  REFERENCES `HCEMed`.`Usuarios` (`idUsuario`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `HCEMed`.`Pagos` 
ADD INDEX `fk_idPlanTratPago_idx` (`idPlanTratamiento` ASC);
ALTER TABLE `HCEMed`.`Pagos` 
ADD CONSTRAINT `fk_idPlanTratPago`
  FOREIGN KEY (`idPlanTratamiento`)
  REFERENCES `HCEMed`.`PlanesDeTratamiento` (`idPlanDeTratamiento`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

ALTER TABLE `HCEMed`.`PlanesDeTratamiento` 
ADD INDEX `fk_idPacientePlanTrat_idx` (`idPaciente` ASC);
ALTER TABLE `HCEMed`.`PlanesDeTratamiento` 
ADD CONSTRAINT `fk_idPacientePlanTrat`
  FOREIGN KEY (`idPaciente`)
  REFERENCES `HCEMed`.`Pacientes` (`idPaciente`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

ALTER TABLE `HCEMed`.`Tratamientos` 
ADD INDEX `fk_idPacienteTrat_idx` (`idPaciente` ASC);
ALTER TABLE `HCEMed`.`Tratamientos` 
ADD CONSTRAINT `fk_idPacienteTrat`
  FOREIGN KEY (`idPaciente`)
  REFERENCES `HCEMed`.`Pacientes` (`idPaciente`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;