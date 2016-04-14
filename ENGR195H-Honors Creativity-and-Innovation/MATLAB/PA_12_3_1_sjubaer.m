% PA 12.3.1 : Calculate Area of I-Beam
% File : PA_12_3_1_sjubaer.m
% By : Shadman Jubaer
% Login : sjubaer
% Section : 3Whalen
% Team : Team 51
%
% ELECTRONIC SIGNITURE
% Shadman Jubaer
%
% The electronic signature above indicates
% the program submitted for evaluation is
% my individual work, and I have a general
% understanding of all aspects of its
% development and execution.
% 
% PROGRAM DESCRIPTION
% My function saves the world by calculating the 
% cross sectional area of an I-Beam
%%
function [Area, Vector] = PA_12_3_1_sjubaer(H,W,T)
AreaI = H * T;
AreaHoriz = 2 * ((W - T) * T);
Area = AreaI + AreaHoriz



