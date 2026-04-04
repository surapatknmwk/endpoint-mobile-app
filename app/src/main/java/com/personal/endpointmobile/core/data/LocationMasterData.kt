package com.personal.endpointmobile.core.data

import com.personal.endpointmobile.domain.model.District
import com.personal.endpointmobile.domain.model.Province
import com.personal.endpointmobile.domain.model.SubDistrict

object LocationMasterData {

    val provinces: List<Province> by lazy { listOf(sakonNakhon) }

    // Fast lookup maps — O(1) access for DDL cascade
    val districtsByProvinceId: Map<Int, List<District>> by lazy {
        provinces.associate { it.id to it.districts }
    }

    val subDistrictsByDistrictId: Map<Int, List<SubDistrict>> by lazy {
        provinces.flatMap { it.districts }
            .associate { it.id to it.subDistricts }
    }

    // ─────────────────────────────────────────
    // จังหวัดสกลนคร  (รหัส 47)
    // ─────────────────────────────────────────
    private val sakonNakhon = Province(
        id = 47,
        name = "สกลนคร",
        districts = listOf(

            // 4701 อำเภอเมืองสกลนคร
            District(4701, "เมืองสกลนคร", listOf(
                SubDistrict(470101, "ธาตุเชิงชุม", "47000"),
                SubDistrict(470102, "ขมิ้น", "47220"),
                SubDistrict(470103, "งิ้วด่อน", "47000"),
                SubDistrict(470104, "บ้านแป้น", "47000"),
                SubDistrict(470105, "ท่าแร่", "47230"),
                SubDistrict(470106, "ม่วงลาย", "47000"),
                SubDistrict(470107, "ดงมะไฟ", "47000"),
                SubDistrict(470108, "ธาตุนาเวง", "47000"),
                SubDistrict(470109, "เหล่าปอแดง", "47000"),
                SubDistrict(470110, "หนองลาด", "47220"),
                SubDistrict(470111, "ฮางโฮง", "47000"),
                SubDistrict(470112, "โนนหอม", "47000"),
            )),

            // 4702 อำเภอกุสุมาลย์
            District(4702, "กุสุมาลย์", listOf(
                SubDistrict(470201, "กุสุมาลย์", "47210"),
                SubDistrict(470202, "นาโพธิ์", "47210"),
                SubDistrict(470203, "นาเพียง", "47230"),
                SubDistrict(470204, "โพธิไพศาล", "47210"),
                SubDistrict(470205, "อุ่มจาน", "47210"),
            )),

            // 4703 อำเภอกุดบาก
            District(4703, "กุดบาก", listOf(
                SubDistrict(470301, "กุดบาก", "47180"),
                SubDistrict(470302, "นาม่อง", "47180"),
                SubDistrict(470303, "กุดไห", "47180"),
            )),

            // 4704 อำเภอพรรณานิคม
            District(4704, "พรรณานิคม", listOf(
                SubDistrict(470401, "พรรณา", "47130"),
                SubDistrict(470402, "วังยาง", "47130"),
                SubDistrict(470403, "พอกน้อย", "47130"),
                SubDistrict(470404, "นาหัวบึง", "47130"),
                SubDistrict(470405, "เชิงชุม", "47130"),
                SubDistrict(470406, "ไร่", "47130"),
                SubDistrict(470407, "ช้างมิ่ง", "47130"),
                SubDistrict(470408, "นาใน", "47130"),
                SubDistrict(470409, "สว่าง", "47130"),
                SubDistrict(470410, "บะฮี", "47130"),
                SubDistrict(470411, "เมืองไพร", "47130"),
                SubDistrict(470412, "นางาม", "47130"),
            )),

            // 4705 อำเภอพังโคน
            District(4705, "พังโคน", listOf(
                SubDistrict(470501, "ม่วงไข่", "47160"),
                SubDistrict(470502, "แร่", "47160"),
                SubDistrict(470503, "ไฮหย่อง", "47160"),
                SubDistrict(470504, "ต้นผึ้ง", "47160"),
            )),

            // 4706 อำเภอวาริชภูมิ
            District(4706, "วาริชภูมิ", listOf(
                SubDistrict(470601, "วาริชภูมิ", "47150"),
                SubDistrict(470602, "ปลาโหล", "47150"),
                SubDistrict(470603, "หนองลาด", "47150"),
                SubDistrict(470604, "คำบ่อ", "47150"),
                SubDistrict(470605, "ค้อเขียว", "47150"),
            )),

            // 4707 อำเภอนิคมน้ำอูน
            District(4707, "นิคมน้ำอูน", listOf(
                SubDistrict(470701, "นิคมน้ำอูน", "47270"),
                SubDistrict(470702, "สุวรรณคาม", "47270"),
                SubDistrict(470703, "หนองปลิง", "47270"),
                SubDistrict(470704, "อินทร์แปลง", "47270"),
            )),

            // 4708 อำเภอวานรนิวาส
            District(4708, "วานรนิวาส", listOf(
                SubDistrict(470801, "วานรนิวาส", "47120"),
                SubDistrict(470802, "เดื่อศรีคันไชย", "47120"),
                SubDistrict(470803, "ขัวก่าย", "47120"),
                SubDistrict(470804, "หนองสนม", "47120"),
                SubDistrict(470805, "คูสะคาม", "47120"),
                SubDistrict(470806, "ธาตุ", "47120"),
                SubDistrict(470807, "หนองแวง", "47120"),
                SubDistrict(470808, "ศรีวิชัย", "47120"),
                SubDistrict(470809, "นาซอ", "47120"),
                SubDistrict(470810, "อินทร์แปลง", "47120"),
                SubDistrict(470811, "นาเดื่อ", "47120"),
                SubDistrict(470812, "เหล่าโพนค้อ", "47120"),
                SubDistrict(470813, "คอนสวรรค์", "47120"),
                SubDistrict(470814, "กุดเรือคำ", "47120"),
                SubDistrict(470815, "หนองแวงใต้", "47120"),
            )),

            // 4709 อำเภอคำตากล้า
            District(4709, "คำตากล้า", listOf(
                SubDistrict(470901, "คำตากล้า", "47250"),
                SubDistrict(470902, "หนองบัวสิม", "47250"),
                SubDistrict(470903, "นาแต้", "47250"),
                SubDistrict(470904, "แพด", "47250"),
            )),

            // 4710 อำเภอบ้านม่วง
            District(4710, "บ้านม่วง", listOf(
                SubDistrict(471001, "ม่วง", "47140"),
                SubDistrict(471002, "บ้านเหล่า", "47140"),
                SubDistrict(471003, "โนนสะอาด", "47140"),
                SubDistrict(471004, "หนองกวั่ง", "47140"),
                SubDistrict(471005, "ห้วยหลัว", "47140"),
                SubDistrict(471006, "โนนคระ", "47140"),
                SubDistrict(471007, "โนนบุ่น", "47140"),
                SubDistrict(471008, "ดงหม้อทอง", "47140"),
                SubDistrict(471009, "ดงหม้อทองใต้", "47140"),
                SubDistrict(471010, "ดงเหนือ", "47140"),
            )),

            // 4711 อำเภออากาศอำนวย
            District(4711, "อากาศอำนวย", listOf(
                SubDistrict(471101, "อากาศ", "47170"),
                SubDistrict(471102, "โพนแพง", "47170"),
                SubDistrict(471103, "วาใหญ่", "47170"),
                SubDistrict(471104, "โพนงาม", "47170"),
                SubDistrict(471105, "ท่าก้อน", "47170"),
                SubDistrict(471106, "นาฮี", "47170"),
                SubDistrict(471107, "บะหว้า", "47170"),
                SubDistrict(471108, "สามัคคีพัฒนา", "47170"),
            )),

            // 4712 อำเภอสว่างแดนดิน
            District(4712, "สว่างแดนดิน", listOf(
                SubDistrict(471201, "สว่างแดนดิน", "47110"),
                SubDistrict(471202, "คำสะอาด", "47110"),
                SubDistrict(471203, "บ้านต้าย", "47110"),
                SubDistrict(471204, "บงเหนือ", "47110"),
                SubDistrict(471205, "พันนา", "47240"),
                SubDistrict(471206, "โคกสี", "47110"),
                SubDistrict(471207, "หนองหลวง", "47110"),
                SubDistrict(471208, "บงใต้", "47110"),
                SubDistrict(471209, "ค้อใต้", "47110"),
                SubDistrict(471210, "แวง", "47240"),
                SubDistrict(471211, "โพนสูง", "47110"),
                SubDistrict(471212, "โคกสูง", "47110"),
            )),

            // 4713 อำเภอส่องดาว
            District(4713, "ส่องดาว", listOf(
                SubDistrict(471301, "ส่องดาว", "47190"),
                SubDistrict(471302, "ท่าศิลา", "47190"),
                SubDistrict(471303, "วัฒนา", "47190"),
                SubDistrict(471304, "โพนงาม", "47190"),
            )),

            // 4714 อำเภอเต่างอย
            District(4714, "เต่างอย", listOf(
                SubDistrict(471401, "เต่างอย", "47260"),
                SubDistrict(471402, "บึงทวาย", "47260"),
                SubDistrict(471403, "นาตาล", "47260"),
                SubDistrict(471404, "สามัคคี", "47260"),
            )),

            // 4715 อำเภอโคกศรีสุพรรณ
            District(4715, "โคกศรีสุพรรณ", listOf(
                SubDistrict(471501, "ตองโขบ", "47280"),
                SubDistrict(471502, "เหล่าโพนค้อ", "47280"),
                SubDistrict(471503, "ด่านม่วงคำ", "47280"),
                SubDistrict(471504, "แมดนาท่ม", "47280"),
            )),

            // 4716 อำเภอเจริญศิลป์
            District(4716, "เจริญศิลป์", listOf(
                SubDistrict(471601, "เจริญศิลป์", "47290"),
                SubDistrict(471602, "ทุ่งแก", "47290"),
                SubDistrict(471603, "โคกศิลา", "47290"),
                SubDistrict(471604, "หนองแปน", "47290"),
                SubDistrict(471605, "บ้านเป็ด", "47290"),
            )),

            // 4717 อำเภอโพนนาแก้ว
            District(4717, "โพนนาแก้ว", listOf(
                SubDistrict(471701, "บ้านโพน", "47230"),
                SubDistrict(471702, "นาแก้ว", "47230"),
                SubDistrict(471703, "นาตงวัฒนา", "47230"),
                SubDistrict(471704, "บ้านแป้น", "47230"),
                SubDistrict(471705, "เชียงสือ", "47230"),
            )),

            // 4718 อำเภอภูพาน
            District(4718, "ภูพาน", listOf(
                SubDistrict(471801, "สร้างค้อ", "47180"),
                SubDistrict(471802, "หลุบเลา", "47180"),
                SubDistrict(471803, "โคกภู", "47180"),
                SubDistrict(471804, "กกปลาซิว", "47180"),
            )),
        )
    )
}
