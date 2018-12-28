##                               								 ID  STOCK PRICE NAME ID_Incompativeis  ID_extras ID_modelos, Tipo


##### ID_Incompativeis -> Indica os componentes incompativeis ao escolher este

##### ID_extras -> Indica se para ter um determinado componente que extras é preciso ter

##### ID_modelos -> Indica que partes compõe um modelo

# Componente Principal
INSERT INTO DSS.Componente values(100,0, 0, 'Motor', null,null,"3,4,5,6,7,8,9",4);
INSERT INTO DSS.Componente values(101,0, 0, 'Pneu', null,null,"10,11,12,13,14,15,16,17",4);
INSERT INTO DSS.Componente values(102,0, 0, 'Transmissão', null,null,"18,19,20,21",4);
INSERT INTO DSS.Componente values(103,0, 0, 'Suspensão', null,null,"22,23,24,25,26",4);


# Modelos

#  SobreAlimentação
INSERT INTO DSS.Componente values(1,6, 350, 'TurboCompressor', "2",null,null,3);
INSERT INTO DSS.Componente values(2,8, 280, 'SuperCompressor', "1",null,null,3);

# Motor
INSERT INTO DSS.Componente values(3,3,     500, 'Motor Turbo',    "3,4,5,6,7,8,9,100","1",null,2);
INSERT INTO DSS.Componente values(4,7,     450, 'Motor 2.0',        "3,4,5,6,7,8,9,100","2",null,2);
INSERT INTO DSS.Componente values(5,20,   400, 'Motor 1.8',        "3,4,5,6,7,8,9,100",null,null,2);
INSERT INTO DSS.Componente values(6,40,   350, 'Motor 1.6',        "3,4,5,6,7,8,9,100",null,null,2);
INSERT INTO DSS.Componente values(7,100, 300, 'Motor 1.4',        "3,4,5,6,7,8,9,100",null,null,2);
INSERT INTO DSS.Componente values(8,100, 250, 'Motor 1.0',        "3,4,5,6,7,8,9,100",null,null,2);
INSERT INTO DSS.Componente values(9,50,   500, 'Motor Elétrico', "3,4,5,6,7,8,9,100","79",null,2);

# PNEU
INSERT INTO DSS.Componente values(10,20, 100, 'Pneus largos',                           "10,11,12,13,14,15,16,17,101","57",null,2);
INSERT INTO DSS.Componente values(11,30, 70,   'Pneus XL',                                "10,11,12,13,14,15,16,17,101","58",null,2);
INSERT INTO DSS.Componente values(12,50, 80,   'Pneus de baixo perfil',              "10,11,12,13,14,15,16,17,101","61",null,2);
INSERT INTO DSS.Componente values(13,70, 40,   'Pneus usados',                         "10,11,12,13,14,15,16,17,101",null,null,2);
INSERT INTO DSS.Componente values(14,20, 45,   'Pneus recauchutados',             "10,11,12,13,14,15,16,17,101",null,null,2);
INSERT INTO DSS.Componente values(15,50, 60,   'Pneus de verão',                       "10,11,12,13,14,15,16,17,101",null,null,2);
INSERT INTO DSS.Componente values(16,30, 60,   'Pneus de inverno',                    "10,11,12,13,14,15,16,17,101",null,null,2);
INSERT INTO DSS.Componente values(17,90, 90,   'Pneus para todas as estações',"10,11,12,13,14,15,16,17,101",null,null,2);


# Transmissão
INSERT INTO DSS.Componente values(18,15, 90,   'Transmissão Automatizada de dupla embreagem',  "18,19,20,21,102",null,null,2);
INSERT INTO DSS.Componente values(19,5,   75,   'Transmissão CVT',                                                    "18,19,20,21,102",null,null,2);
INSERT INTO DSS.Componente values(20,20, 130, 'Transmissão Automático',                                         "18,19,20,21,102",null,null,2);
INSERT INTO DSS.Componente values(21,50, 160, 'Transmissão Sequencial',                                         "18,19,20,21,102",null,null,2);

# Suspensão
INSERT INTO DSS.Componente values(22,30, 180, 'Suspensão Eixo rígido',                         "22,23,24,25,26,103",null,null,2);
INSERT INTO DSS.Componente values(23,27, 170, 'Suspensão Independente',                    "22,23,24,25,26,103",null,null,2);
INSERT INTO DSS.Componente values(24,20, 160, 'Suspensão MacPherson',                      "22,23,24,25,26,103",null,null,2);
INSERT INTO DSS.Componente values(25,10, 210, 'Suspensão Triângulo duplo',                 "22,23,24,25,26,103",null,null,2);
INSERT INTO DSS.Componente values(26,15, 220, 'Suspensão Multilink',                             "22,23,24,25,26,103",null,null,2);

# Componente Acessorio
# VIDROS
INSERT INTO DSS.Componente values(27,50, 65, 'Para-brisas Pipi',                        "27,28,29,30,31", null,null,3);
INSERT INTO DSS.Componente values(28,50, 80, 'Para-brisas Fixe',                       "27,28,29,30,31", null,null,3);
INSERT INTO DSS.Componente values(29,80, 60, 'Para-brisas de Vidro',                 "27,28,29,30,31", null,null,3);
INSERT INTO DSS.Componente values(30,90, 70, 'Para-brisas de Vidro laminado', "27,28,29,30,31", null,null,3);
INSERT INTO DSS.Componente values(31,90, 75, 'Para-brisas com faixa cinza',     "27,28,29,30,31", null,null,3);

#Tech
INSERT INTO DSS.Componente values(32,90, 30, 'Kit Wifi',                  "32,33,34", null,null,3);
INSERT INTO DSS.Componente values(33,170, 25, 'Kit Bluetooth',         "32,33,34", null,null,3);
INSERT INTO DSS.Componente values(34,30, 20, 'Kit Infra-Vermelho', "32,33,34", null,null,3);
INSERT INTO DSS.Componente values(35,230, 27, 'Kit mãos-livres com interface USB', null, null,null,3);
INSERT INTO DSS.Componente values(36,220, 180, 'AutoPilot', null, "37,38",null,3);
INSERT INTO DSS.Componente values(37,180, 70, 'Informação de trânsito em tempo real', null, null,null,3);
INSERT INTO DSS.Componente values(38,210, 40, 'Sistema de navegação Professional', null, "37",null,3);

# Som
INSERT INTO DSS.Componente values(39,30, 40, 'Sistema de som HiFi', "39,40,41,42", null,null,3);
INSERT INTO DSS.Componente values(40,40, 50, 'Sistema de som Harman Kardon', "39,40,41,42", null,null,3);
INSERT INTO DSS.Componente values(41,80, 20, 'Sistema Stereo', "39,40,41,42", null,null,3);
INSERT INTO DSS.Componente values(42,110, 120, 'Dolby Atmos', "39,40,41,42", null,null,3);

# Extra body
INSERT INTO DSS.Componente values(43,30, 210, 'Spoiler', null, null,null,3);
INSERT INTO DSS.Componente values(44,20, 540, 'Full Car Body Kit', "44,45,46,47", "43",null,3);
INSERT INTO DSS.Componente values(45,35, 450, 'Ground Effects Kit', "44,45,46,47", "43",null,3);
INSERT INTO DSS.Componente values(46,40, 420, 'Wide Body Kit', "44,45,46,47", null,null,3);
INSERT INTO DSS.Componente values(47,50, 280, 'Bumper Replacement Kit', "44,45,46,47", null,null,3);

# Travão
INSERT INTO DSS.Componente values(48,40, 160, 'Travões desportivo', "48,49,50,51", null,null,3);
INSERT INTO DSS.Componente values(49,140, 110, 'Travões de tambor', "48,49,50,51", null,null,3);
INSERT INTO DSS.Componente values(50,110, 140, 'Travões de disco', "48,49,50,51", null,null,3);
INSERT INTO DSS.Componente values(51,210, 200, 'ABS', "48,49,50,51", null,null,3);

# Segurança
INSERT INTO DSS.Componente values(52,90,   50, 'Airbag',                       null,null,null,3);
INSERT INTO DSS.Componente values(53,200, 30, 'Cintos de segurança', null,null,null,3);
INSERT INTO DSS.Componente values(54,300, 60, 'Luzes',                        null,null,null,3);

# Aquecedor
INSERT INTO DSS.Componente values(55,60, 70, 'Aquecedor central', "55",null,null,3);
INSERT INTO DSS.Componente values(56,90, 60, 'Ar condicionado',    "56",null,null,3);

# Tamanho da roda
INSERT INTO DSS.Componente values(57,15, 110, '20"', "57,58,59,60,61",null,null,3);
INSERT INTO DSS.Componente values(58,30, 100, '18"', "57,58,59,60,61",null,null,3);
INSERT INTO DSS.Componente values(59,50, 90,   '17"', "57,58,59,60,61",null,null,3);
INSERT INTO DSS.Componente values(60,70, 80,   '16"', "57,58,59,60,61",null,null,3);
INSERT INTO DSS.Componente values(61,60, 70,   '15"', "57,58,59,60,61",null,null,3);

# Tipos de bancos
INSERT INTO DSS.Componente values(62,50,   140, 'Banco de couro animal',    "62,63,64",null,null,3);
INSERT INTO DSS.Componente values(63,120, 100, 'Banco de couro sintético', "62,63,64",null,null,3);
INSERT INTO DSS.Componente values(64,240, 80,   'Banco de tecido',               "62,63,64",null,null,3);

# Cor do interior
INSERT INTO DSS.Componente values(65,80, 30, 'Interior Preto',              "65,66,67,68,69",null,null,3);
INSERT INTO DSS.Componente values(66,60, 35, 'Interior Cor Amêndoa', "65,66,67,68,69",null,null,3);
INSERT INTO DSS.Componente values(67,30, 30, 'Interior Vermelho',        "65,66,67,68,69",null,null,3);
INSERT INTO DSS.Componente values(68,20, 40, 'Interior Bege',               "65,66,67,68,69",null,null,3);
INSERT INTO DSS.Componente values(69,80, 45, 'Interior Grafite',            "65,66,67,68,69",null,null,3);
INSERT INTO DSS.Componente values(70,40, 30, 'Interior Branco',           "65,66,67,68,69",null,null,3);


# Cor do exterior
INSERT INTO DSS.Componente values(71,200, 70, 'Exterior Preto',            "71,72,73,74",null,null,3);
INSERT INTO DSS.Componente values(72,40,   75, 'Exterior Vermelho',     "71,72,73,74",null,null,3);
INSERT INTO DSS.Componente values(73,100, 80, 'Exterior Azul Escuro', "71,72,73,74",null,null,3);
INSERT INTO DSS.Componente values(74,150, 90, 'Exterior Branco',         "71,72,73,74",null,null,3);

# Jantes

INSERT INTO DSS.Componente values(75,200, 110, 'Jantes de liga leve',            "75,76,77,78",null,null,3);
INSERT INTO DSS.Componente values(76,40,   75,  'Jantes fundidas',                 "75,76,77,78",null,null,3);
INSERT INTO DSS.Componente values(77,100, 80, 'Jantes forjadas',                  "75,76,77,78",null,null,3);
INSERT INTO DSS.Componente values(78,150, 85, 'Jantes modulares',              "75,76,77,78",null,null,3);

# Componente para o carro eletrico
INSERT INTO DSS.Componente values(79,15, 70, 'Condensador', null,null,null,3);

# Troll
INSERT INTO DSS.Componente values(80,40, 80, 'Bandeira Tuga', null,null,null,3);
INSERT INTO DSS.Componente values(81,50, 200, 'Sistema de exclusão do Pisca', null,null,null,3);
INSERT INTO DSS.Componente values(82,50, 300, 'Sistema de exclusão da capacidade de andar na faixa da direita', null,null,null,3);
#########################################################

# PACOTES
INSERT INTO DSS.Pacote values(1, 'Desportivo', 0, "75,27,44,48");
INSERT INTO DSS.Pacote values(2, 'Preto', 0,"65,71");
INSERT INTO DSS.Pacote values(3, 'Vermelho', 0,"72,67");
INSERT INTO DSS.Pacote values(4, 'Segurança', 0,"52,53,54");
INSERT INTO DSS.Pacote values(5, 'Tech', 0,"55,79,42,36,37,38,35");
INSERT INTO DSS.Pacote values(6, 'Tuga', 0,"80,81");
INSERT INTO DSS.Pacote values(7, 'Avec', 0,"80,82");

# DELETE FROM Componente;
# DELETE FROM Pacote;
# select * from Componente;
# select * from Pacote;