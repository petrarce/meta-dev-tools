SUMMARY = "Heap memory profiler for Linux"
DESCRIPTION = "Heaptrack traces all memory allocations and annotates these \
events with stack traces. Dedicated analysis tools then allow you to interpret \
the heap memory profile to find hotspots to reduce memory, leaks, allocation \
hotspots and temporary allocations"
HOMEPAGE = "https://phabricator.kde.org/source/heaptrack/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSES/MIT.txt;md5=7dda4e90ded66ab88b86f76169f28663"

DEPENDS = " \
	zlib \
	boost \
	libunwind \
	elfutils \
	qtbase \
"

SRC_URI = "git://github.com/KDE/heaptrack.git;protocol=https;branch=master"

#v1.4.0
SRCREV = "9e5514ecbbf56c8d5307717e4d1c70cc58dc27fe"

S = "${WORKDIR}/git"

inherit cmake

# libunwind is not yet ported to RISCV
COMPATIBLE_HOST:riscv32 = "null"
COMPATIBLE_HOST:riscv64 = "null"

BBCLASSEXTEND = "native nativesdk"
