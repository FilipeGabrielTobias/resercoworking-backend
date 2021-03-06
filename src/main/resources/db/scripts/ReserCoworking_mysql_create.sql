CREATE TABLE `Usuario` (
	`nr_cpf` INT(11) NOT NULL,
	`nm_usuario` varchar(255) NOT NULL,
	`cd_perfil` INT NOT NULL,
	`cd_endereco` INT NOT NULL,
	`dt_nascimento` DATETIME NOT NULL,
	`nr_telefone` INT(11) NOT NULL,
	`nm_email` varchar(255) NOT NULL,
	`qt_pontos` varchar(255) NOT NULL,
	`nm_login` varchar(255) NOT NULL,
	`nm_senha` varchar(255) NOT NULL,
	`status_usuario` TIMESTAMP(1) NOT NULL,
	PRIMARY KEY (`nr_cpf`)
);

CREATE TABLE `Cidade` (
	`cd_cidade` INT NOT NULL AUTO_INCREMENT,
	`nm_cidade` varchar(255) NOT NULL,
	`cd_estado` INT(255) NOT NULL,
	PRIMARY KEY (`cd_cidade`)
);

CREATE TABLE `Estado` (
	`cd_estado` INT NOT NULL AUTO_INCREMENT,
	`nm_uf` TIMESTAMP(2) NOT NULL,
	`nm_estado` varchar(255) NOT NULL,
	`cd_pais` INT NOT NULL,
	PRIMARY KEY (`cd_estado`)
);

CREATE TABLE `País` (
	`cd_pais` INT NOT NULL AUTO_INCREMENT,
	`nm_pais` varchar(255) NOT NULL,
	PRIMARY KEY (`cd_pais`)
);

CREATE TABLE `Perfil` (
	`cd_perfil` INT NOT NULL AUTO_INCREMENT,
	`nm_perfil` varchar(255) NOT NULL,
	`nr_autenticacao` INT NOT NULL,
	PRIMARY KEY (`cd_perfil`)
);

CREATE TABLE `Modalidade` (
	`cd_modalidade` INT NOT NULL AUTO_INCREMENT,
	`nm_modalidade` varchar(255) NOT NULL,
	PRIMARY KEY (`cd_modalidade`)
);

CREATE TABLE `Espaço` (
	`cd_espaço` INT NOT NULL AUTO_INCREMENT,
	`nm_espaço` varchar(255) NOT NULL,
	`tamanho_espaço` varchar(255) NOT NULL,
	`cd_modalidade` INT(255) NOT NULL,
	`vl_hora` FLOAT(3,2) NOT NULL,
	`qt_pontos` INT NOT NULL,
	PRIMARY KEY (`cd_espaço`)
);

CREATE TABLE `Reserva` (
	`cd_espaço` INT NOT NULL,
	`nr_cpf` INT(11) NOT NULL,
	`dt_reserva_inicio` DATETIME NOT NULL,
	`dt_reserva_fim` DATETIME NOT NULL,
	`vl_total` FLOAT(5,2) NOT NULL,
	`qt_pontos_total` INT NOT NULL,
	`cd_feedback` INT NOT NULL,
	`status_reserva` varchar(1) NOT NULL,
	PRIMARY KEY (`cd_espaço`,`nr_cpf`)
);

CREATE TABLE `Feedback` (
	`cd_feedback` INT NOT NULL AUTO_INCREMENT,
	`ds_feedback` varchar(255) NOT NULL,
	`nota_feedback` INT NOT NULL,
	PRIMARY KEY (`cd_feedback`)
);

CREATE TABLE `Mensagem` (
	`cd_mensagem` INT NOT NULL AUTO_INCREMENT,
	`ds_mensagem` varchar(255) NOT NULL,
	`dt_mensagem` DATE NOT NULL,
	PRIMARY KEY (`cd_mensagem`)
);

CREATE TABLE `Envio` (
	`cd_usuario` INT NOT NULL,
	`cd_mensagem` INT NOT NULL,
	PRIMARY KEY (`cd_usuario`,`cd_mensagem`)
);

CREATE TABLE `Recebimento` (
	`cd_mensagem` INT NOT NULL,
	`cd_usuario` INT NOT NULL,
	PRIMARY KEY (`cd_mensagem`,`cd_usuario`)
);

CREATE TABLE `Premiação` (
	`cd_premiação` INT NOT NULL AUTO_INCREMENT,
	`nm_premiação` varchar(255) NOT NULL,
	`ds_premiação` varchar(255) NOT NULL,
	`img_premiação` blob NOT NULL,
	`qt_pontos` INT NOT NULL,
	PRIMARY KEY (`cd_premiação`)
);

CREATE TABLE `Endereco` (
	`cd_endereco` INT NOT NULL AUTO_INCREMENT,
	`nm_rua` INT NOT NULL,
	`cd_bairro` INT NOT NULL,
	PRIMARY KEY (`cd_endereco`)
);

CREATE TABLE `Bairro` (
	`cd_bairro` INT NOT NULL AUTO_INCREMENT,
	`nm_bairro` varchar(255) NOT NULL,
	`cd_cidade` INT NOT NULL,
	PRIMARY KEY (`cd_bairro`)
);

CREATE TABLE `Aquisição` (
	`cd_premiação` INT NOT NULL,
	`nr_cpf` INT(11) NOT NULL,
	`dt_aquisicao` DATETIME NOT NULL,
	PRIMARY KEY (`cd_premiação`,`nr_cpf`)
);

ALTER TABLE `Usuario` ADD CONSTRAINT `Usuario_fk0` FOREIGN KEY (`cd_perfil`) REFERENCES `Perfil`(`cd_perfil`);

ALTER TABLE `Usuario` ADD CONSTRAINT `Usuario_fk1` FOREIGN KEY (`cd_endereco`) REFERENCES `Endereco`(`cd_endereco`);

ALTER TABLE `Cidade` ADD CONSTRAINT `Cidade_fk0` FOREIGN KEY (`cd_estado`) REFERENCES `Estado`(`cd_estado`);

ALTER TABLE `Estado` ADD CONSTRAINT `Estado_fk0` FOREIGN KEY (`cd_pais`) REFERENCES `País`(`cd_pais`);

ALTER TABLE `Espaço` ADD CONSTRAINT `Espaço_fk0` FOREIGN KEY (`cd_modalidade`) REFERENCES `Modalidade`(`cd_modalidade`);

ALTER TABLE `Reserva` ADD CONSTRAINT `Reserva_fk0` FOREIGN KEY (`cd_espaço`) REFERENCES `Espaço`(`cd_espaço`);

ALTER TABLE `Reserva` ADD CONSTRAINT `Reserva_fk1` FOREIGN KEY (`nr_cpf`) REFERENCES `Usuario`(`nr_cpf`);

ALTER TABLE `Reserva` ADD CONSTRAINT `Reserva_fk2` FOREIGN KEY (`cd_feedback`) REFERENCES `Feedback`(`cd_feedback`);

ALTER TABLE `Envio` ADD CONSTRAINT `Envio_fk0` FOREIGN KEY (`cd_usuario`) REFERENCES `Usuario`(`nr_cpf`);

ALTER TABLE `Envio` ADD CONSTRAINT `Envio_fk1` FOREIGN KEY (`cd_mensagem`) REFERENCES `Mensagem`(`cd_mensagem`);

ALTER TABLE `Recebimento` ADD CONSTRAINT `Recebimento_fk0` FOREIGN KEY (`cd_mensagem`) REFERENCES `Mensagem`(`cd_mensagem`);

ALTER TABLE `Recebimento` ADD CONSTRAINT `Recebimento_fk1` FOREIGN KEY (`cd_usuario`) REFERENCES `Usuario`(`nr_cpf`);

ALTER TABLE `Premiação` ADD CONSTRAINT `Premiação_fk0` FOREIGN KEY (`qt_pontos`) REFERENCES `Pontos`(`cd_pontos`);

ALTER TABLE `Endereco` ADD CONSTRAINT `Endereco_fk0` FOREIGN KEY (`cd_bairro`) REFERENCES `Bairro`(`cd_bairro`);

ALTER TABLE `Bairro` ADD CONSTRAINT `Bairro_fk0` FOREIGN KEY (`cd_cidade`) REFERENCES `Cidade`(`cd_cidade`);

ALTER TABLE `Aquisição` ADD CONSTRAINT `Aquisição_fk0` FOREIGN KEY (`cd_premiação`) REFERENCES `Premiação`(`cd_premiação`);

ALTER TABLE `Aquisição` ADD CONSTRAINT `Aquisição_fk1` FOREIGN KEY (`nr_cpf`) REFERENCES `Usuario`(`nr_cpf`);

